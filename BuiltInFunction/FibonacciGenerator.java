// Importing scanner class from util package
import java.util.Scanner;
// Generate a Fibonacci series using the number provided
public class FibonacciGenerator 
{

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Get number of terms from the user
        int terms = sc.nextInt();

        // Generate and print the Fibonacci sequence
        printFibonacciSequence(terms);
	// Closing scanner class
        sc.close();
    }

    // Function to generate and print Fibonacci sequence
    public static void printFibonacciSequence(int terms)
    {
        int first = 0, second = 1;

        System.out.println("Fibonacci Sequence up to " + terms + " terms:");

        for (int i = 1; i <= terms; i++)
        {
            System.out.print(first + " ");

            // Calculate next term
            int next = first + second;
            first = second;
            second = next;
        }
    }
}
