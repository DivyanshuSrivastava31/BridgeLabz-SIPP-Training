// Importing scanner class from util package
import java.util.Scanner
// Main class to define the object of PalindromeChecker class
public class MainPalindromeChecker
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking text from the user
		String text=sc.nextLine();
		
		// Creating object and calling method to display the result
		PalindromeChecker objCheck = new PalindromeChecker(text);
		objCheck.checkPalindrome();
		objCheck.displayDetails();
		
		// Closing object of scanner class
		sc.close();
	}
}