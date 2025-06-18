// Importing Scanner class from util package
import java.util.Scanner;
// Calculate sum of natural numbers using methods
public class NaturalNumberSum 
{

    // Recursive method to calculate sum of n natural numbers
    public static int sumRecursive(int n)
    {
        if (n == 1)
            return 1;
        return n + sumRecursive(n - 1);
    }

    // Formula method to calculate sum: n(n+1)/2
    public static int sumFormula(int n)
    {
        return (n * (n + 1)) / 2;
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input number from the user
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
            return;
        }

        int recursiveSum = sumRecursive(n);
        int formulaSum = sumFormula(n);

        // Display both results
        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);

        // Confirm if both results match
        System.out.println("Both results are " + (recursiveSum == formulaSum ? "equal." : "different."));
	// Closing scanner class
	sc.close();
    }
}
