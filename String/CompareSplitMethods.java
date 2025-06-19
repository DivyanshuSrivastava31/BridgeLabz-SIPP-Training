// Importing scanner class from util package
import java.util.Scanner;
// Creating split method and comparing result with in-built split() function
public class CompareSplitMethods 
{

    // Custom method to get length of a string
    public static int getLength(String str)
    {
        int count = 0;
        try 
	{
            while (true)
	    {
                str.charAt(count);
                count++;
            }
        } 
	catch (Exception e) 
	{
            // End of string
        }
        return count;
    }

    // Custom method to split text into words (no split())
    public static String[] customSplit(String text)
    {
        int len = getLength(text);
        int wordCount = 0;
        boolean inWord = false;

        // Count words
        for (int i = 0; i < len; i++) 
	{
            if (text.charAt(i) != ' ') 
	    {
                if (!inWord) 
		{
                    wordCount++;
                    inWord = true;
                }
            }
	    else
	    {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        StringBuilder word = new StringBuilder();
        int index = 0;

        for (int i = 0; i < len; i++) 
	{
            char ch = text.charAt(i);
            if (ch != ' ')
	    {
                word.append(ch);
            } 
	    else if (word.length() > 0)
	    {
                words[index++] = word.toString();
                word.setLength(0);
            }
        }

        // Add the last word
        if (word.length() > 0) 
	{
            words[index] = word.toString();
        }

        return words;
    }

    // Method to compare two String arrays
    public static boolean compareArrays(String[] a, String[] b) 
    {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) 
	{
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    // Display arrays for verification
    public static void displayArray(String[] arr, String label) 
    {
        System.out.println(label + ":");
        for (String word : arr) 
	{
            System.out.print(word + " | ");
        }
        System.out.println();
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
	// Taking string input from the user
        String input = sc.nextLine();

        String[] customWords = customSplit(input);
        String[] builtInWords = input.trim().split("\\s+"); // More reliable split

        // Display arrays
        displayArray(customWords, "Custom Split");
        displayArray(builtInWords, "Built-in Split");
	// Comparing arrays
        boolean isEqual = compareArrays(customWords, builtInWords);
        System.out.println("Are both word arrays equal? " + isEqual);
	// Closing scanner class
	sc.close();
    }
}
