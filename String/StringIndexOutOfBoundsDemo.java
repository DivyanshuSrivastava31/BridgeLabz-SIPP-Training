// Importing scanner class from util package
import java.util.Scanner;
// Demonstrating String Index Out Of Bounds Exception using charAt function
public class StringIndexOutOfBoundsDemo 
{

    // Method to handle the StringIndexOutOfBoundsException
    public static void handleException(String text)
    {
        try 
	{
            // Accessing out-of-bounds index deliberately
            char ch = text.charAt(text.length());
            System.out.println("Character: " + ch);
        } 
	catch (StringIndexOutOfBoundsException e) 
	{
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
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

        // Taking String type input from the user
        String input = sc.nextLine();

        // Call method to handle the exception properly
        handleException(input);
	//Closing scanner class
	sc.close();
    }
}
