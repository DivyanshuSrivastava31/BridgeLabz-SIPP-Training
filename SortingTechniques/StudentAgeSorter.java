import java.util.Scanner;

public class StudentAgeSorter {

    // Counting Sort implementation (for ages 10 to 18)
    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];     // Frequency array
        int[] output = new int[ages.length]; // Sorted result array

        // Step 1: Count the occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place the elements in sorted order (from end for stability)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Step 4: Copy output array back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Utility to print the array
    public static void printArray(int[] arr) {
        System.out.print("Sorted Student Ages: ");
        for (int age : arr) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter the student ages (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
            if (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Invalid age entered. Please enter age between 10 and 18.");
                i--; // repeat input for same index
            }
        }

        countingSort(ages);   // Sort using Counting Sort
        printArray(ages);     // Display sorted ages

        sc.close();
    }
}
