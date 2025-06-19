// Importing scanner class from util package
import java.util.Scanner
// Comparing two strings and displaying the result
public class EqualStrings
{
	// Method to compare the two strings return the result
	public static boolean comparingEqualStrings(String text1, String text2)
	{
		if(text1.length()!=text2.length())
			return false;
		else
		{
			for(int loop=0;loop<text1.length();loop++)
			{
				if(text1.charAt(loop)!=text2.charAt(loop))
					return false;
			}
		}
		return true;
	}
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking 2 string inputs from the user
		String text1=sc.nextLine();
		String text2=sc.nextLine();
		// Invoking method to compare the two strings
		boolean result = comparingEqualStrings(text1,text2);
		boolean check = text1.equals(text2);
		// Displaying result
		if(check==result)
		{
			System.out.println("Result : True");
		}
		else
		{
			System.out.println("Result : False");
		}
		// Closing scanner class
		sc.close();
	}
}