// Importing Scanner class from util package
import java.util.Scanner;
// Trimming a string without using in-built function
public class TrimString 
{

    // Method to find the start and end indices of non-space characters
    public static int[] findTrimBounds(String text)
    {
        int start = 0, end = text.length() - 1;

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') 
	{
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') 
	{
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt
    public static String customSubstring(String text, int start, int end)
    {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) 
	{
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    // Method to compare two strings using charAt
    public static boolean compareStrings(String s1, String s2)
    {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) 
	{
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
        // Taking string input from the user
        String input = sc.nextLine();

        // Custom trim using charAt()
        int[] bounds = findTrimBounds(input);
        String trimmedCustom = customSubstring(input, bounds[0], bounds[1]);

        // Using built-in trim method
        String trimmedBuiltin = input.trim();

        // Comparison
        boolean isEqual = compareStrings(trimmedCustom, trimmedBuiltin);

        // Display result
        System.out.println("Original Text: >" + input + "<");
        System.out.println("Custom Trimmed: >" + trimmedCustom + "<");
        System.out.println("Built-in Trimmed: >" + trimmedBuiltin + "<");
        System.out.println("Are both results equal? " + isEqual);
    }
}
