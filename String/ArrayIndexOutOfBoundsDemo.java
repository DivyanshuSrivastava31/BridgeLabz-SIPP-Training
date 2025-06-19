// Importing Scanner class from util package
import java.util.Scanner;
// Demonstrating array index out of bounds exception
public class ArrayIndexOutOfBoundsDemo 
{

    // Method that generates ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) 
    {
        // Trying to access index beyond array length (e.g., index 5 in a 3-element array)
        System.out.println("Accessing element at index 5: " + names[5]); // This will throw exception
    }

    // Method that handles ArrayIndexOutOfBoundsException
    public static void handleException(String[] names)
    {
        try 
	{
            System.out.println("Accessing element at index 5: " + names[5]);
        } 
	catch (ArrayIndexOutOfBoundsException e) 
	{
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } 
	catch (RuntimeException e) 
	{
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Define and imput a names array with 3 elements from the user
        String[] names = new String[3];

        for (int i = 0; i < names.length; i++) 
	{
            names[i] = sc.nextLine();
        }

        // Call method that generates unhandled exception
        System.out.println("\nGenerating ArrayIndexOutOfBoundsException (This may crash):");
        try 
	{
            generateException(names);
        } 
	catch (Exception e) 
	{
            System.out.println("Exception caught in main: " + e);
        }

        // Call method that safely handles exception
        System.out.println("\nHandling ArrayIndexOutOfBoundsException safely:");
        handleException(names);
	// Closing scanner class
        sc.close();
    }
}
