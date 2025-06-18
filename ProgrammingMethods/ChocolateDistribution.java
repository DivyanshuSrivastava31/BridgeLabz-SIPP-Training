// Importing Scanner class from util package
import java.util.Scanner;
// Compute to find distribution of chocolates among children
public class ChocolateDistribution 
{

    // Method to find quotient and remainder to find distribution of chocolates
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

        // Input number of chocolates and children from the user
        int chocolates = sc.nextInt();
        int children = sc.nextInt();

        // Calculate and display result
        if (children == 0) 
	{
            System.out.println("Cannot divide by zero children.");
        } 
	else 
	{
            int[] result = findRemainderAndQuotient(chocolates, children);
            System.out.println("Each child gets: " + result[0] + " chocolates");
            System.out.println("Remaining chocolates: " + result[1]);
        }
	// Closing scanner class
	sc.close();
    }
}
