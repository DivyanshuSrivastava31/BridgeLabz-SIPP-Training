import java.util.*;

public class SearchDataStructureComparison {

    // Linear Search in Array
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    // Performance Test Method
    public static void compareSearch(int size, int target) {
        Random rand = new Random();
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            int val = rand.nextInt(size * 10);
            array[i] = val;
            hashSet.add(val);
            treeSet.add(val);
        }

        System.out.println("\nDataset Size: " + size);

        // Linear Search
        long start = System.nanoTime();
        boolean foundArray = linearSearch(array, target);
        long end = System.nanoTime();
        System.out.println("Array Search Time: " + (end - start) / 1_000_000.0 + " ms");

        // HashSet Search
        start = System.nanoTime();
        boolean foundHash = hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) / 1_000_000.0 + " ms");

        // TreeSet Search
        start = System.nanoTime();
        boolean foundTree = treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) / 1_000_000.0 + " ms");

        System.out.println("Found? Array=" + foundArray + ", HashSet=" + foundHash + ", TreeSet=" + foundTree);
    }

    public static void main(String[] args) {
        int target = 123456;  // Target to search
        compareSearch(1_000, target);
        compareSearch(100_000, target);
        compareSearch(1_000_000, target);
    }
}
