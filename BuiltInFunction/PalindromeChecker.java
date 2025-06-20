// Importing scanner class from util package
import java.util.Scanner;
// Check if the phrase is palindrome or not
public class PalindromeChecker 
{

    public static void main(String... args)
    {
        // Get input from user
        String input = getInput();

        // Check if it's a palindrome
        boolean isPalindrome = checkPalindrome(input);

        // Display result
        displayResult(input, isPalindrome);
    }

    // Function to get user input
    public static String getInput()
    {
        // Creating object of scanner class
	Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // Closing scanner class
	sc.close();
        return input;
    }

    // Function to check if a string is a palindrome
    public static boolean checkPalindrome(String str) 
    {
        // Remove spaces and convert to lowercase
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();

        // Reverse the cleaned string
        String reversed = new StringBuilder(cleaned).reverse().toString();

        // Compare cleaned with reversed
        return cleaned.equals(reversed);
    }

    // Function to display the result
    public static void displayResult(String original, boolean isPalindrome)
    {
        if (isPalindrome) 
	{
            System.out.println("\"" + original + "\" is a palindrome.");
        } 
	else 
	{
            System.out.println("\"" + original + "\" is NOT a palindrome.");
        }
    }
}
