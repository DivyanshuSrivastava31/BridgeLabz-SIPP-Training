import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    // HashMap to store product prices: Product Name -> Price
    private Map<String, Double> productPrices;

    // LinkedHashMap to maintain the order of items added to the cart
    // This will store: Product Name -> Quantity
    private LinkedHashMap<String, Integer> cartItemsOrdered;

    // TreeMap to display items sorted by price
    // This will store: Price -> List of Product Names (to handle multiple items with same price)
    private TreeMap<Double, List<String>> cartItemsSortedByPrice;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cartItemsOrdered = new LinkedHashMap<>();
        // Using a custom comparator for TreeMap to sort by price ascending.
        // If prices are the same, secondary sorting could be by product name.
        cartItemsSortedByPrice = new TreeMap<>();
        
        // Populate some sample product prices
        productPrices.put("Laptop", 1200.00);
        productPrices.put("Mouse", 25.00);
        productPrices.put("Keyboard", 75.00);
        productPrices.put("Monitor", 300.00);
        productPrices.put("Webcam", 50.00);
        productPrices.put("USB Drive", 25.00); // Another item with price 25.00
    }

    /**
     * Adds an item to the shopping cart.
     *
     * @param productName The name of the product to add.
     * @param quantity    The quantity of the product.
     */
    public void addItemToCart(String productName, int quantity) {
        if (!productPrices.containsKey(productName)) {
            System.out.println("Error: Product '" + productName + "' not found in price list.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be positive for '" + productName + "'.");
            return;
        }

        // Update LinkedHashMap (maintains insertion order)
        cartItemsOrdered.put(productName, cartItemsOrdered.getOrDefault(productName, 0) + quantity);

        // Update TreeMap (for sorted display by price)
        double price = productPrices.get(productName);
        
        // Temporarily remove existing entry if product already in cart and its quantity changed
        // This is crucial for correct sorting by price if an item's total price changes due to quantity.
        // However, the requirement is "display items sorted by price", not "total price of all quantities".
        // So we just add the product name to the list at its base price.
        // If the same product is added multiple times, it will appear multiple times in the list
        // within the same price bucket.
        
        cartItemsSortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(productName);

        System.out.println(quantity + " x '" + productName + "' added to cart.");
    }

    /**
     * Removes an item from the shopping cart.
     *
     * @param productName The name of the product to remove.
     */
    public void removeItemFromCart(String productName) {
        if (!cartItemsOrdered.containsKey(productName)) {
            System.out.println("Error: Product '" + productName + "' not in cart.");
            return;
        }

        // Remove from LinkedHashMap
        cartItemsOrdered.remove(productName);

        // Remove from TreeMap
        double price = productPrices.get(productName);
        List<String> productsAtPrice = cartItemsSortedByPrice.get(price);
        if (productsAtPrice != null) {
            productsAtPrice.remove(productName); // Remove only one instance
            if (productsAtPrice.isEmpty()) {
                cartItemsSortedByPrice.remove(price);
            }
        }
        System.out.println("'" + productName + "' removed from cart.");
    }

    /**
     * Displays all items currently in the cart in the order they were added.
     * Uses LinkedHashMap.
     */
    public void displayCartInOrderAdded() {
        System.out.println("\n--- Shopping Cart Items (Order Added) ---");
        if (cartItemsOrdered.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cartItemsOrdered.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(productName);
            double itemTotal = price * quantity;
            System.out.printf("%s (x%d) - $%.2f each | Total: $%.2f%n", productName, quantity, price, itemTotal);
            total += itemTotal;
        }
        System.out.printf("--- Total Cart Value: $%.2f%n", total);
    }

    /**
     * Displays all items currently in the cart sorted by their individual product price.
     * Uses TreeMap.
     */
    public void displayCartSortedByPrice() {
        System.out.println("\n--- Shopping Cart Items (Sorted by Price) ---");
        if (cartItemsSortedByPrice.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        for (Map.Entry<Double, List<String>> entry : cartItemsSortedByPrice.entrySet()) {
            double price = entry.getKey();
            List<String> products = entry.getValue();
            for (String productName : products) {
                // Find the quantity from cartItemsOrdered to display full info
                int quantity = cartItemsOrdered.getOrDefault(productName, 0);
                if (quantity > 0) { // Only display if still in cart with positive quantity
                    System.out.printf("%s (x%d) - $%.2f each%n", productName, quantity, price);
                }
            }
        }
    }

    /**
     * Calculates and displays the total price of all items in the cart.
     * Uses the HashMap for product prices and LinkedHashMap for quantities.
     */
    public void calculateAndDisplayTotal() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cartItemsOrdered.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(productName); // Get price from HashMap
            total += price * quantity;
        }
        System.out.printf("\n--- Final Cart Total: $%.2f%n", total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add items to the cart
        cart.addItemToCart("Laptop", 1);
        cart.addItemToCart("Mouse", 2);
        cart.addItemToCart("Monitor", 1);
        cart.addItemToCart("Keyboard", 1);
        cart.addItemToCart("USB Drive", 3); // Another item with $25 price

        // Display cart contents in order added
        cart.displayCartInOrderAdded();

        // Display cart contents sorted by price
        cart.displayCartSortedByPrice();
        
        // Remove an item
        cart.removeItemFromCart("Mouse");
        
        // Display cart contents again after removal
        cart.displayCartInOrderAdded();
        cart.displayCartSortedByPrice();
        
        // Add an item that doesn't exist
        cart.addItemToCart("External HDD", 1);

        // Calculate and display final total
        cart.calculateAndDisplayTotal();
    }
}