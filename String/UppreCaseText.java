// Importing scanner class from util package
import java.util.Scanner;
// Converting complete text to Uppercase text
public class UppreCaseText
{
	// Method to convert the complete text to Uppre case
	public static String toUpperCase(String text)
	{
		String newText = new String();
		for(int loop=0; loop<text.length(); loop++)
		{
			int number=text.charAt(loop);
			if(number>=97&&number<=122)
			{
				newText=newText+(number-32);
			}
		}
		return newText;
	}
	// Method to compare both the results and return result
	public static boolean comparingResult(String text1, String text2)
	{
		return text1.equals(text2);
	}
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking string input from the user
		String text=sc.nextLine();
		String upperCaseText=toUppreCase(text);
		String newText=text.toUppreCase();
		boolean result=comparingResult(lowerCaseText,newText);
		// Displaying result
		System.out.println("Result : "+result);
		// Closing scanner class
		sc.close();
	}
}
		