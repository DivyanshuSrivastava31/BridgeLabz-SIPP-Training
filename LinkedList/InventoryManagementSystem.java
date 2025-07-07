// Node class
class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Linked List
public class InventoryManagementSystem {
    ItemNode head;

    int getCount() {
        int count = 0;
        ItemNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode item = new ItemNode(itemName, itemId, quantity, price);
        item.next = head;
        head = item;
    }

    void addAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode item = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = item;
        } else {
            ItemNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = item;
        }
    }

    void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position <= 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        if (position > getCount() + 1) {
            System.out.println("Invalid position entered");
            return;
        }

        ItemNode item = new ItemNode(itemName, itemId, quantity, price);
        ItemNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        item.next = current.next;
        current.next = item;
    }

    void deleteItemById(int itemId) {
        if (head == null) return;

        if (head.itemId == itemId) {
            head = head.next;
            return;
        }

        ItemNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Item not found.");
        } else {
            current.next = current.next.next;
        }
    }

    void updateQuantity(int itemId, int newQuantity) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
    }

    void searchItem(int itemId, String itemName) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId || current.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item found:");
                System.out.println("Name: " + current.itemName);
                System.out.println("ID: " + current.itemId);
                System.out.println("Quantity: " + current.quantity);
                System.out.println("Price: " + current.price);
            }
            current = current.next;
        }
    }

    void calculateTotalValue() {
        double total = 0;
        ItemNode current = head;
        while (current != null) {
            total += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    void displayInventory() {
        int count = 0;
        ItemNode current = head;
        while (current != null) {
            ++count;
            System.out.println(count + ". Item Details:");
            System.out.println("Name: " + current.itemName);
            System.out.println("ID: " + current.itemId);
            System.out.println("Quantity: " + current.quantity);
            System.out.println("Price: ₹" + current.price);
            current = current.next;
        }
    }

    // Bubble sort based on name or price
    void sortInventory(String by, boolean ascending) {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            ItemNode current = head;
            while (current.next != null) {
                boolean condition = false;

                if (by.equalsIgnoreCase("name")) {
                    condition = ascending
                        ? current.itemName.compareToIgnoreCase(current.next.itemName) > 0
                        : current.itemName.compareToIgnoreCase(current.next.itemName) < 0;
                } else if (by.equalsIgnoreCase("price")) {
                    condition = ascending
                        ? current.price > current.next.price
                        : current.price < current.next.price;
                }

                if (condition) {
                    // Swap values
                    String tmpName = current.itemName;
                    int tmpId = current.itemId;
                    int tmpQty = current.quantity;
                    double tmpPrice = current.price;

                    current.itemName = current.next.itemName;
                    current.itemId = current.next.itemId;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;

                    current.next.itemName = tmpName;
                    current.next.itemId = tmpId;
                    current.next.quantity = tmpQty;
                    current.next.price = tmpPrice;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public static void main(String[] args) {
        InventoryManagementSystem item = new InventoryManagementSystem();

        item.addAtBeginning("Monitor", 101, 10, 7000.0);
        item.addAtEnd("Keyboard", 102, 20, 500.0);
        item.addAtEnd("Mouse", 103, 30, 300.0);
        item.addAtPosition("CPU", 104, 5, 25000.0, 2);

        System.out.println("Initial Inventory:");
        item.displayInventory();
        System.out.println();

        item.updateQuantity(103, 50);
        item.deleteItemById(102);
        item.searchItem(104, "CPU");

        System.out.println("\nInventory after Updates:");
        item.displayInventory();

        System.out.println("\nTotal Inventory Value:");
        item.calculateTotalValue();

        System.out.println("\nInventory Sorted by Name (Ascending):");
        item.sortInventory("name", true);
        item.displayInventory();

        System.out.println("\nInventory Sorted by Price (Descending):");
        item.sortInventory("price", false);
        item.displayInventory();
    }
}
