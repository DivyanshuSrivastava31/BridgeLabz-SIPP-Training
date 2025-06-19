// Importing Scanner class from util package
import java.util.Scanner;
// Extract words from a given text and store in a 2-D Array
public class SplittingText
{
	// Method to split texts into words
	public static String[][] splittingText(String str)
	{
		String trimmedtext=str.trim();
		String text=trimmedtext.append(" ");
		String[][] splitText=new String[text.length()][1];
		int count=0;
		int startindex=0;
		for(int loop=0; loop<text.length();loop++)
		{
			// Splitting text using substring
			if(text.charAt(loop)==" ")
			{
				splitText[count][0]=text.substring(startindex,loop)
				count++;
				startindex=loop+1;
			}
		}
		return splitText;
	}
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking integer input from the user
		String text =  br.readLine();
		// Invoking method to split functions
		String[][] text = splittingText(text);
		// Displaying result
		for word in text:
			System.out.println(word);
		// Closing scanner class
		sc.close();
	}
}