// Importing Scanner class from util package
import java.util.Scanner;
// Check the largest and the smallest number among three
public class MinMaxOfThree 
{

    // Method to find the smallest and largest among 3 numbers
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) 
    {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }

    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input three numbers from the user
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        // Get smallest and largest
        int[] result = findSmallestAndLargest(num1, num2, num3);

        // Display the result
        System.out.println("Smallest number is: " + result[0]);
        System.out.println("Largest number is: " + result[1]);
	// Closing scanner class
	sc.close();
    }
}
