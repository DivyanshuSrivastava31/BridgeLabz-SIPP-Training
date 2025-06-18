// Importing Scanner class from util package
import java.util.Scanner;
//Compute quotient and remainder of two numbers
public class QuotientRemainder 
{

    // Method to find quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) 
    {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input two numbers from the user

        int number = sc.nextInt();

        int divisor = sc.nextInt();

        // Calculate and display quotient and remainder
        if (divisor == 0) 
	{
            System.out.println("Division by zero is not allowed.");
        } 
	else 
	{
            int[] result = findRemainderAndQuotient(number, divisor);
            System.out.println("Quotient: " + result[0]);
            System.out.println("Remainder: " + result[1]);
        }
	// Closing scanner class
	sc.close();
    }
}
