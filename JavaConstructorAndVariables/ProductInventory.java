// Define a class to keep track of products in an inventory
public class ProductInventory
{
    // Initialize variables to store data
    String productName;
    double price;
    static int totalProducts = 0;  // class variable

    // Constructor
    ProductInventory(String productName, double price) 
    {
        this.productName = productName;
        this.price = price;
        totalProducts++;  // increment for every new object
    }

    // Instance method to display product details
    void displayProductDetails() 
    {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    // Class method to display total number of products
    static void displayTotalProducts() 
    {
        System.out.println("Total Products Created: " + totalProducts);
    }

    // Main method to test
    public static void main(String... args) 
    {
        ProductInventory p1 = new ProductInventory("Laptop", 75000.0);
        ProductInventory p2 = new ProductInventory("Smartphone", 25000.0);
        ProductInventory p3 = new ProductInventory("Headphones", 2000.0);

        System.out.println("Product 1 Details:");
        p1.displayProductDetails();

        System.out.println("\nProduct 2 Details:");
        p2.displayProductDetails();

        System.out.println("\nProduct 3 Details:");
        p3.displayProductDetails();

        System.out.println("\n--- Inventory Summary ---");
        Product.displayTotalProducts();  // calling class method
    }
}
