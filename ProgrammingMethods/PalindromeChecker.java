// Importing Arrays class from util package
import java.util.Arrays;
// Importing Scanner class from util package
import java.util.Scanner;
// Check whether a number is palindrome or not
public class PalindromeChecker 
{

    // Get digits
    public static int[] getDigits(int number) 
    {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) 
	{
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    // Reverse digits
    public static int[] reverseDigits(int[] digits)
    {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) 
	{
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Compare arrays
    public static boolean areEqual(int[] a, int[] b)
    {
        return Arrays.equals(a, b);
    }

    // Check if number is palindrome
    public static boolean isPalindrome(int[] digits)
    {
        return areEqual(digits, reverseDigits(digits));
    }

    // Check if number is Duck Number
    public static boolean isDuckNumber(int[] digits)
    {
        for (int i = 1; i < digits.length; i++) 
	{
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
	//Taking integer input from the user
        int number = sc.nextInt();
	// Declaring two arrays to store digits and reverse the number
        int[] digits = getDigits(number);
        int[] reversed = reverseDigits(digits);
	// Displaying the result
        System.out.println("Original digits: " + Arrays.toString(digits));
        System.out.println("Reversed digits: " + Arrays.toString(reversed));
        System.out.println("Palindrome? " + isPalindrome(digits));
        System.out.println("Duck Number? " + isDuckNumber(digits));
	// Closing scanner class
	sc.close();
    }
}
