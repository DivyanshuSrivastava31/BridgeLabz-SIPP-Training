// Importing Scanner class from util package
import java.util.Scanner;
// Demonstrating Number format exception
public class NumberFormatExceptionDemo 
{

    // Method that generates NumberFormatException
    public static void generateException()
    {
	// Creating object of scanner class
	Scanner sc = new Scanner(System.in);
        // Input a String that is not a valid number
        String text = sc.nextLine();

        // This will throw NumberFormatException
        int number = Integer.parseInt(text);

        // This line won't be executed because of the exception above
        System.out.println("Parsed number: " + number);
	// Closing scanner class
	sc.close();
    }

    // Method that handles the NumberFormatException using try-catch block
    public static void handleException()
    {
	// Creating object of scanner class
	Scanner sc = new Scanner(System.in);
        // Input a String that is not a valid number
        String text = sc.nextLine();

        try 
	{
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } 
	catch (NumberFormatException e) 
	{
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } 
	catch (RuntimeException e) 
	{
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
	// Closing scanner class
	sc.close();
    }

    public static void main(String... args)
    {
        System.out.println("Generating NumberFormatException (This will crash the program):");
        try
	{
            generateException();
        } 
	catch (Exception e) 
	{
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println("\nHandling NumberFormatException safely:");
        handleException();
    }
}
