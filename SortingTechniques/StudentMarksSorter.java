import java.util.Scanner;

public class StudentMarksSorter {

    // Bubble sort implementation
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap adjacent elements
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps happened, array is already sorted
            if (!swapped)
                break;
        }
    }

    // Utility to print the array
    public static void printArray(int[] arr) {
        System.out.print("Sorted Marks: ");
        for (int mark : arr) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        System.out.println("Enter the marks of " + n + " students:");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        bubbleSort(marks); // Sort using bubble sort
        printArray(marks); // Display sorted marks

        sc.close();
    }
}
