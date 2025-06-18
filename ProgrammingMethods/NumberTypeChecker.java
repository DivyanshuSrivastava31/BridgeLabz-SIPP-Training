// Importing Scanner class from util package
import java.util.Scanner;
// Check whether a number is perfect number, abundant number, deficient number, or strong number
public class NumberTypeChecker 
{

    // Sum of proper divisors (excluding the number itself)
    public static int sumOfDivisors(int number)
    {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++)
        {
            if (number % i == 0) sum += i;
        }
        return sum;
    }

    // Check for perfect number
    public static boolean isPerfect(int number)
    {
        return sumOfDivisors(number) == number;
    }

    // Check for abundant number
    public static boolean isAbundant(int number)
    {
        return sumOfDivisors(number) > number;
    }

    // Check for deficient number
    public static boolean isDeficient(int number)
    {
        return sumOfDivisors(number) < number;
    }

    // Calculate factorial of a digit
    public static int factorial(int n) 
    {
        int result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;
        return result;
    }

    // Check for strong number (sum of factorial of digits = number)
    public static boolean isStrong(int number)
    {
        int sum = 0, temp = number;
        while (temp > 0) 
	{
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == number;
    }

    public static void main(String... args)
    {
        // Creating object of scanner class
        Scanner sc = new Scanner(System.in);
	// Take integer number from the user
        int number = sc.nextInt();
	// Displaying result
        System.out.println("Perfect Number? " + isPerfect(number));
        System.out.println("Abundant Number? " + isAbundant(number));
        System.out.println("Deficient Number? " + isDeficient(number));
        System.out.println("Strong Number? " + isStrong(number));
	// Closing scanner class
	sc.close();
    }
}
