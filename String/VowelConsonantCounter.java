// Importing scanner class from util package
import java.util.Scanner;
// Count number of vowels and consonants and display it
public class VowelConsonantCounter 
{

    // Method to determine if a character is a vowel
    public static boolean isVowel(char ch)
    {
        ch = Character.toLowerCase(ch);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    // Method to check if character is a letter
    public static boolean isLetter(char ch)
    {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    // Method to count vowels and consonants
    public static int[] countVowelsAndConsonants(String text)
    {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) 
	{
            char ch = text.charAt(i);
            if (isLetter(ch))
	    {
                if (isVowel(ch))
		{
                    vowels++;
                } 
		else 
		{
                    consonants++;
                }
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
        // Taking string input from the user
        String input = sc.nextLine();

        int[] result = countVowelsAndConsonants(input);
	// Displaying result
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
	// Closing scanner class
	sc.close();
    }
}
