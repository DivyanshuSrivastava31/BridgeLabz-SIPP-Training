// Importing Scanner class from util package
import java.util.Scanner;
// Check whether the number is positive, negative or zero, and compare first and last element
public class NumberAnalysis
{

    // Method to check if number is positive
    public static boolean isPositive(int num) 
    {
        return num > 0;
    }

    // Method to check if number is even
    public static boolean isEven(int num) 
    {
        return num % 2 == 0;
    }

    // Method to compare two numbers
    public static int compare(int a, int b) 
    {
        if (a > b) return 1;
        else if (a == b) return 0;
        else return -1;
    }

    public static void main(String... args) 
    {
	// Creating object of Scanner class
        Scanner sc = new Scanner(System.in);
	// Declare an array to store numbers
        int[] numbers = new int[5];

        // Input 5 numbers from the user
        for (int i = 0; i < 5; i++) 
	{
            numbers[i] = sc.nextInt();
        }

        // Analyze each number
        for (int i = 0; i < 5; i++) 
	{
            int num = numbers[i];
            if (isPositive(num)) 
	    {
                System.out.print("Number " + num + " is Positive and ");
                System.out.println(isEven(num) ? "Even." : "Odd.");
            } 
	    else
	    {
                System.out.println("Number " + num + " is Negative.");
            }
        }

        // Compare first and last
        int result = compare(numbers[0], numbers[4]);
        System.out.print("First number (" + numbers[0] + ") is ");
        if (result == 0)
            System.out.println("equal to the last number (" + numbers[4] + ").");
        else if (result > 0)
            System.out.println("greater than the last number (" + numbers[4] + ").");
        else
            System.out.println("less than the last number (" + numbers[4] + ").");
	// Closing scanner class
	sc.close();
    }
}
