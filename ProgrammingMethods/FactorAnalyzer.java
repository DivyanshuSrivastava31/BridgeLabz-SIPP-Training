// Importing Scanner class from util package
import java.util.Scanner;
// Compute factors, sum of factors, product of factors, and sum of square of product of factors
public class FactorAnalyzer 
{

    // Method to find and return the factors of a number
    public static int[] findFactors(int number) 
    {
        int count = 0;

        // First pass: count how many factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        // Second pass: store factors
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Method to calculate sum of factors
    public static int sumOfFactors(int[] factors) 
    {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to calculate product of factors
    public static int productOfFactors(int[] factors) 
    {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to calculate sum of squares of factors
    public static double sumOfSquares(int[] factors) 
    {
        double sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input number from the user
        int number = sc.nextInt();

        // Find factors
        int[] factors = findFactors(number);

        // Display factors
        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }

        // Display sum, product, and sum of squares
        System.out.println("\nSum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
	// Closing scanner class
	sc.close();
    }
}
