import java.util.*;

public class SortComparison {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        mergeSortRecursive(arr, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortRecursive(arr, left, mid);
        mergeSortRecursive(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    private static void quickSortRecursive(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortRecursive(arr, low, pi - 1);
            quickSortRecursive(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    // Benchmark
    public static void compareSorts(int size) {
        Random rand = new Random();
        int[] base = new int[size];
        for (int i = 0; i < size; i++) {
            base[i] = rand.nextInt(size * 10);
        }

        System.out.println("\nDataset Size: " + size);

        if (size <= 10_000) {
            int[] bubbleData = Arrays.copyOf(base, size);
            long start = System.nanoTime();
            bubbleSort(bubbleData);
            long end = System.nanoTime();
            System.out.println("Bubble Sort Time: " + (end - start) / 1_000_000.0 + " ms");
        } else {
            System.out.println("Bubble Sort: Skipped (too slow)");
        }

        int[] mergeData = Arrays.copyOf(base, size);
        long start = System.nanoTime();
        mergeSort(mergeData);
        long end = System.nanoTime();
        System.out.println("Merge Sort Time: " + (end - start) / 1_000_000.0 + " ms");

        int[] quickData = Arrays.copyOf(base, size);
        start = System.nanoTime();
        quickSort(quickData);
        end = System.nanoTime();
        System.out.println("Quick Sort Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        compareSorts(1_000);
        compareSorts(10_000);
        compareSorts(1_000_000);
    }
}
