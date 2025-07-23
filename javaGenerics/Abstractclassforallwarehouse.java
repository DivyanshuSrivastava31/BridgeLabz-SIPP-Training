// Abstract class for all warehouse items
abstract class WarehouseItem {
    private String itemId;
    private String name;

    public WarehouseItem(String itemId, String name) {
        this.itemId = itemId;
        this.name = name;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId + ", Name: " + name;
    }
}

// Concrete item types
class Electronics extends WarehouseItem {
    private String category;

    public Electronics(String itemId, String name, String category) {
        super(itemId, name);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Electronics - " + super.toString() + ", Category: " + category;
    }
}

class Groceries extends WarehouseItem {
    private String expirationDate;

    public Groceries(String itemId, String name, String expirationDate) {
        super(itemId, name);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Groceries - " + super.toString() + ", Expiration Date: " + expirationDate;
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String itemId, String name, String material) {
        super(itemId, name);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Furniture - " + super.toString() + ", Material: " + material;
    }
}

// Generic class for storage
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item.getName());
    }

    public T getItem(String itemId) {
        for (T item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    // Wildcard method to display all items
    public static void displayAllItems(List<? extends WarehouseItem> warehouseItems) {
        System.out.println("\n--- All Items in Storage ---");
        for (WarehouseItem item : warehouseItems) {
            System.out.println(item);
        }
    }
}

public class WarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E001", "Laptop", "Computers"));
        electronicsStorage.addItem(new Electronics("E002", "Smart TV", "Entertainment"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("G001", "Milk", "2025-08-15"));
        groceriesStorage.addItem(new Groceries("G002", "Bread", "2025-07-25"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F001", "Dining Table", "Wood"));

        // Retrieve a specific item
        Electronics laptop = electronicsStorage.getItem("E001");
        if (laptop != null) {
            System.out.println("\nRetrieved: " + laptop.getName());
        }

        // Display all items using the wildcard method
        List<WarehouseItem> allItems = new ArrayList<>();
        allItems.addAll(electronicsStorage.items);
        allItems.addAll(groceriesStorage.items);
        allItems.addAll(furnitureStorage.items);

        Storage.displayAllItems(allItems);
    }
}