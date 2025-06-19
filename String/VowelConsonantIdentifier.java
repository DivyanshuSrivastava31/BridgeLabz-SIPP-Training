// Importing scanner class from util package
import java.util.Scanner;
// Identify vowels, consonants and numbers in a string 
public class VowelConsonantIdentifier 
{

    // Method to check the type of character
    public static String getCharType(char ch)
    {
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) 
	{
            // Convert to lowercase
            char lower = (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') 
	    {
                return "Vowel";
            } 
	    else
 	    {
                return "Consonant";
            }
        } 
	else
	{
            return "Not a Letter";
        }
    }

    // Method to generate 2D array of character and its type
    public static String[][] analyzeText(String text)
    {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) 
	{
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharType(ch);
        }
        return result;
    }

    // Method to display the 2D array
    public static void displayResults(String[][] data) 
    {
        System.out.println("Char\tType");
        for (String[] row : data) 
	{
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] analysis = analyzeText(input);
        displayResults(analysis);
	// Closing scanner class
	sc.close();
    }
}
