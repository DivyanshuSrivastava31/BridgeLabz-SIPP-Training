import java.util.Scanner;

public class EmployeeIDSorter {

    // Insertion sort implementation
    public static void insertionSort(int[] ids) {
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i]; // The current element to insert
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }

            // Insert the key at the correct position
            ids[j + 1] = key;
        }
    }

    // Utility to print the array
    public static void printArray(int[] arr) {
        System.out.print("Sorted Employee IDs: ");
        for (int id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] employeeIds = new int[n];
        System.out.println("Enter the Employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIds[i] = sc.nextInt();
        }

        insertionSort(employeeIds);  // Sort using insertion sort
        printArray(employeeIds);     // Display sorted IDs

        sc.close();
    }
}
