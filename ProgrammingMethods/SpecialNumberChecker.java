// Importing Scanner class from util package
import java.util.Scanner;
// Check whether a number is prime, neon, spy, automorphic, or buzz
public class SpecialNumberChecker 
{

    // Check if number is prime
    public static boolean isPrime(int n)
    {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    // Check if number is Neon (sum of digits of square == number)
    public static boolean isNeon(int number)
    {
        int square = number * number;
        int sum = 0;
        while (square > 0) 
	{
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    // Check if number is Spy (sum of digits == product of digits)
    public static boolean isSpy(int number)
    {
        int sum = 0, product = 1;
        int temp = number;
        while (temp > 0) 
	{
            int d = temp % 10;
            sum += d;
            product *= d;
            temp /= 10;
        }
        return sum == product;
    }

    // Check if number is Automorphic (square ends with number)
    public static boolean isAutomorphic(int number)
    {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    // Check if number is Buzz (divisible by 7 or ends with 7)
    public static boolean isBuzz(int number)
    {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
	// Take integer number from the user
        int number = sc.nextInt();
	// Displaying the result
        System.out.println("Prime? " + isPrime(number));
        System.out.println("Neon? " + isNeon(number));
        System.out.println("Spy? " + isSpy(number));
        System.out.println("Automorphic? " + isAutomorphic(number));
        System.out.println("Buzz? " + isBuzz(number));
	// Closing scanner class
	sc.close();
    }
}
