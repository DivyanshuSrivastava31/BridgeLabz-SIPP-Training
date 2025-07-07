// ParcelNode represents each stage in the delivery chain
class ParcelNode {
    String stage;
    ParcelNode next;

    ParcelNode(String stage) {
        this.stage = stage;
        this.next = null;
    }
}

// ParcelTracker manages the delivery chain using a singly linked list
public class ParcelTracker {
    private ParcelNode head;

    // Initialize with standard delivery chain
    public void initializeDefaultStages() {
        head = new ParcelNode("Packed");
        head.next = new ParcelNode("Shipped");
        head.next.next = new ParcelNode("In Transit");
        head.next.next.next = new ParcelNode("Delivered");
    }

    // Add a custom checkpoint after a specific stage
    public void addCheckpoint(String afterStage, String newCheckpoint) {
        ParcelNode current = head;
        while (current != null && !current.stage.equalsIgnoreCase(afterStage)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Stage '" + afterStage + "' not found.");
        } else {
            ParcelNode checkpoint = new ParcelNode(newCheckpoint);
            checkpoint.next = current.next;
            current.next = checkpoint;
            System.out.println("Checkpoint '" + newCheckpoint + "' added after '" + afterStage + "'.");
        }
    }

    // Mark a parcel as lost by setting next pointer to null at a stage
    public void markParcelLostAt(String stage) {
        ParcelNode current = head;
        while (current != null && !current.stage.equalsIgnoreCase(stage)) {
            current = current.next;
        }
        if (current != null) {
            current.next = null;  // Breaking the chain to indicate missing parcel
            System.out.println("Parcel marked lost after '" + stage + "'.");
        } else {
            System.out.println("Stage '" + stage + "' not found.");
        }
    }

    // Display current tracking chain
    public void displayTrackingChain() {
        ParcelNode current = head;
        while (current != null) {
            System.out.print(current.stage);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Main method for demonstration
    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();
        
        // Initialize default chain
        tracker.initializeDefaultStages();
        System.out.println("Initial Tracking Chain:");
        tracker.displayTrackingChain();

        // Add custom checkpoint
        tracker.addCheckpoint("Shipped", "At Local Hub");
        System.out.println("After Adding Checkpoint:");
        tracker.displayTrackingChain();

        // Mark parcel lost
        tracker.markParcelLostAt("In Transit");
        System.out.println("After Marking Parcel Lost:");
        tracker.displayTrackingChain();
    }
}