// Importing scanner class from util package
import java.util.Scanner
// Creating a substring method and comparing the result with substring() function
public class SubStringMethod
{
	// Method to find the substring from the text
	public static String substring(String text, int startIndex, int endIndex)
	{
		String newText=new String();
		for(int loop=startIndex; loop<endIndex; loop++)
		{
			newText=newText+text.charAt(loop);
		}
		return newText;
	}
	// Method to compare the result
	public static boolean comparingSubStrings(String text1, String text2)
	{
		return text1.equals(text2);
	}
	public static void main(String... args)
	{
		// Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		// Taking String input from the user
		String text=sc.nextLine();
		// Taking start and end index input from the user
		int startIndex=sc.nextInt();
		int endIndex=sc.nextInt();
		// Invoking substring method in the class
		String subtext=subString(text,startIndex,endIndex);
		String subNewText=text.substring(startIndex,endIndex);
		// Invoking method to compare the results
		boolean result=comparingSubStrings(subtext,subNewText);
		// Displaying the result
		System.out.println("Result : "+result);
		// Closing scanner class
		sc.close();
	}
}