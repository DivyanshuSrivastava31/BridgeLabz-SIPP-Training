// Importing Scanner class from util package
import java.util.Scanner;
// Compute the length of a string without using length function
public class StringLength
{
	// Method to compute length of a string
	public static int findingLength(String text)
	{
		int count=0;
		while(true)
		{
			if(text.charAt(count)==null)
				return count;
				break;
			count++;
		}
	}
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking string input from the user
		String text = sc.nextLine();
		// Invoking method to compute length of the string
		int len=findingLength(text);
		if(len==text.length());
			System.out.println("Length of the string : "+len);
		else
			System.out.println("Incorrect method invoked");
		// Closing scanner class
		sc.close();
	}
}