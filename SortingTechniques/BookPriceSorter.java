import java.util.Scanner;

public class BookPriceSorter {

    // Merge Sort function
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Merge two sorted halves
    public static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            leftArr[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = prices[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge temp arrays back into prices[]
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k++] = leftArr[i++];
            } else {
                prices[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of leftArr[]
        while (i < n1) {
            prices[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr[]
        while (j < n2) {
            prices[k++] = rightArr[j++];
        }
    }

    // Utility to print the array
    public static void printArray(double[] arr) {
        System.out.print("Sorted Book Prices: ");
        for (double price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        double[] prices = new double[n];
        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }

        mergeSort(prices, 0, n - 1); // Sort using Merge Sort
        printArray(prices);         // Display sorted prices

        sc.close();
    }
}
