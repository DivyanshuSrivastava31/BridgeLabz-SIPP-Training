import java.util.*;

public class SearchComparison {

    // Linear Search Implementation
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search Implementation
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Measure execution time of a search method
    public static void compareSearch(int size, int target) {
        Random rand = new Random();

        // Generate dataset
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size * 10);
        }

        System.out.println("\nDataset Size: " + size);

        // ---- Linear Search ----
        long startTime = System.nanoTime();
        int linearIndex = linearSearch(data, target);
        long endTime = System.nanoTime();
        System.out.println("Linear Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // ---- Binary Search ----
        Arrays.sort(data);  // Must sort before binary search
        startTime = System.nanoTime();
        int binaryIndex = binarySearch(data, target);
        endTime = System.nanoTime();
        System.out.println("Binary Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Optional: Show positions
        System.out.println("Linear Index: " + linearIndex + ", Binary Index: " + binaryIndex);
    }

    public static void main(String[] args) {
        int target = 123456;  // Random target value

        compareSearch(1_000, target);
        compareSearch(10_000, target);
        compareSearch(1_000_000, target);
    }
}
