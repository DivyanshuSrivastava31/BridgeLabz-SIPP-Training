import java.util.Scanner;

public class ProductPriceSorter {

    // Quick Sort function
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high); // Partition the array
            quickSort(prices, low, pivotIndex - 1);  // Sort left partition
            quickSort(prices, pivotIndex + 1, high); // Sort right partition
        }
    }

    // Partitioning logic (last element as pivot)
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot with element at i+1
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    // Utility to print the array
    public static void printArray(double[] arr) {
        System.out.print("Sorted Product Prices: ");
        for (double price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        double[] prices = new double[n];
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }

        quickSort(prices, 0, n - 1); // Sort using Quick Sort
        printArray(prices);         // Display sorted prices

        sc.close();
    }
}
