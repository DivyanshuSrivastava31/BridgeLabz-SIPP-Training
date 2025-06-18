// Importing Scanner class from util package
import java.util.Scanner;
// Check if a number is positive, negative, or zero
public class NumberChecker 
{

    // Method to check if number is positive, negative, or zero
    public static int checkNumber(int number) 
    {
        if (number > 0)
            return 1;  // Positive
        else if (number < 0)
            return -1; // Negative
        else
            return 0;  // Zero
    }

    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input number from the user
        int number = sc.nextInt();

        // Check and display result
        int result = checkNumber(number);
        if (result == 1)
            System.out.println("The number is Positive.");
        else if (result == -1)
            System.out.println("The number is Negative.");
        else
            System.out.println("The number is Zero.");
	// Closing scanner class
	sc.close();
    }
}
