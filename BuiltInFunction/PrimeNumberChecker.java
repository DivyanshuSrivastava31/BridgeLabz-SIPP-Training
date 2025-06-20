// Importing scanner class from util package
import java.util.Scanner;
// To check whether a number is prime or not
public class PrimeNumberChecker 
{

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Take integer input from user
        int number = sc.nextInt();

        // Check if the number is prime
        if (isPrime(number)) 
 	{
            System.out.println(number + " is a Prime Number.");
        } 
	else 
	{
            System.out.println(number + " is NOT a Prime Number.");
        }
	// Closing scanner class
        sc.close();
    }

    // Function to check if a number is prime
    public static boolean isPrime(int n)
    {
        // Handle edge cases
        if (n <= 1) return false;
        if (n == 2) return true;

        // Only check up to the square root of n
        for (int i = 2; i <= Math.sqrt(n); i++) 
	{
            if (n % i == 0) 
	    {
                return false; // Not prime if divisible
            }
        }
        return true; // Prime if no divisors found
    }
}
