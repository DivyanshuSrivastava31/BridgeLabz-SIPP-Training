// Importing Scanner class from util package
import java.util.Scanner;
// Extract all characters from a string and compare with string array
public class ExtractingCharacters
{
	// Method to Extract characters from string
	public static char[] extractingCharacters(String text)
	{
		// Declaring character array
		char[] textarr=new char[text.length()];
		// Initializing loop to extract charactes
		for(int loop=0; loop<text.length(); loop++)
		{
			textarr[loop]=text.charAt(loop);
		}
		return textarr;
	}
	// Method to compare both the arrays and return result
	public static Boolean comparingArrays(char[] text, char[] textarr)
	{
		Boolean result=true;
		for(int loop=0; loop<text.length; loop++)
		{
			if(text[loop]!=textarr[loop])
			{
				result=false;
				break;
			}
		}
		return result;
	}
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		String text=sc.nextLine();
		// Declaring two character arrays to store characters
		char[] text=extractingCharacters(text);
		char[] textarr=text.toCharArray();
		// Comparing both the arrays
		boolean result = comparingArrays(text,textarr);
		// Displaying the result
		System.out.println("Result : "+result);
		// Closing scanner class
		sc.close();
	}
}
		