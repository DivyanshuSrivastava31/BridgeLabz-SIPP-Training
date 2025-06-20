// Importing scanner class
import java.util.Scanner;
// Calculating factorial using recursion
public class FactorialRecursion 
{

    public static void main(String... args) 
    {
        // Get user input
        int number = getInput();

        // Calculate factorial using recursion
        long result = factorial(number);

        // Display the result
        displayResult(number, result);
    }

    // Function to get input from the user
    public static int getInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer to find its factorial: ");
        int num = sc.nextInt();
	// Closing scanner class
        sc.close();
        return num;
    }

    // Recursive function to calculate factorial
    public static long factorial(int n)
    {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    // Function to display the result
    public static void displayResult(int number, long result)
    {
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
