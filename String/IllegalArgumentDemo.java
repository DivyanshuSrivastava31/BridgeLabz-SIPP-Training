// Importing Scanner class from util package
import java.util.Scanner;
// Demonstrating Illegal Arguments exception through substring function
public class IllegalArgumentDemo 
{

    // Method to handle the IllegalArgumentException using try-catch
    public static void handleException(String text)
    {
        try 
	{
            // This will throw IllegalArgumentException
            String sub = text.substring(5, 2);
            System.out.println("Substring: " + sub);
        } 
	catch (IllegalArgumentException e) 
	{
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } 
	catch (RuntimeException e) 
	{
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String... args)
    {	
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Taking string input from the user
        String input = sc.nextLine();
        // Proper handling using try-catch
        handleException(input);
	//Closing scanner class
	sc.close();
    }
}
