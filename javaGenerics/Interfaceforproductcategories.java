// Interface for product categories
interface ProductCategory {
    String getCategoryName();
}

// Concrete product categories
class BookCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}

// Generic Product class with bounded type parameter for category
class Product<T extends ProductCategory> {
    private String productId;
    private String name;
    private double price;
    private T category;

    public Product(String productId, String name, double price, T category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + name + ", Price: $" + String.format("%.2f", price) + ", Category: " + category.getCategoryName();
    }
}

class ProductCatalog {

    // Generic method to apply discounts
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double currentPrice = product.getPrice();
        double discountedPrice = currentPrice * (1 - percentage / 100);
        product.setPrice(discountedPrice);
        System.out.println("Applied " + percentage + "% discount to " + product.getName() + ". New price: $" + String.format("%.2f", discountedPrice));
    }

    public static void main(String[] args) {
        // Create products with different categories
        Product<BookCategory> novel = new Product<>("B001", "The Great Gatsby", 15.99, new BookCategory());
        Product<ClothingCategory> tShirt = new Product<>("C001", "Cotton T-Shirt", 25.00, new ClothingCategory());
        Product<GadgetCategory> smartphone = new Product<>("G001", "Smartphone X", 799.99, new GadgetCategory());

        // Add products to a catalog (using a List to demonstrate multiple categories)
        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(novel);
        catalog.add(tShirt);
        catalog.add(smartphone);

        System.out.println("--- Original Catalog ---");
        catalog.forEach(System.out::println);

        // Apply discounts using the generic method
        applyDiscount(novel, 10);
        applyDiscount(smartphone, 5);

        System.out.println("\n--- Catalog After Discounts ---");
        catalog.forEach(System.out::println);

        // Example of adding another product
        Product<BookCategory> textbook = new Product<>("B002", "Java Programming Guide", 50.00, new BookCategory());
        catalog.add(textbook);
        System.out.println("\n--- Catalog After Adding Textbook ---");
        catalog.forEach(System.out::println);
    }
}