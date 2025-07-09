class CustomHashMap {

    static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public CustomHashMap() {
        buckets = new Node[SIZE];
    }

    private int getBucketIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    public void put(int key, int value) {
        int index = getBucketIndex(key);
        Node head = buckets[index];

        // If key already exists, update it
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
        }

        // Else insert new node at head
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = getBucketIndex(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1; // not found
    }

    public void remove(int key) {
        int index = getBucketIndex(key);
        Node curr = buckets[index], prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Optional: for debugging
    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            Node curr = buckets[i];
            if (curr != null) {
                System.out.print("Bucket " + i + ": ");
                while (curr != null) {
                    System.out.print("[" + curr.key + "->" + curr.value + "] ");
                    curr = curr.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(1001, 30); // collision with key 1 if SIZE = 1000

        System.out.println("Get 1: " + map.get(1));  // 10
        System.out.println("Get 2: " + map.get(2));  // 20
        System.out.println("Get 3: " + map.get(3));  // -1 (not found)

        map.remove(2);
        System.out.println("After removing 2, Get 2: " + map.get(2)); // -1

        map.printMap(); // Optional to see internal state
    }
}
