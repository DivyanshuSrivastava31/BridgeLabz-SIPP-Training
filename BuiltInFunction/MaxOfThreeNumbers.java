// Importing scanner class from util package
import java.util.Scanner;
// find the maximum of the three numbers
public class MaxOfThreeNumbers 
{

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Get three numbers from the user
        int num1 = getInput(sc, "Enter the first number: ");
        int num2 = getInput(sc, "Enter the second number: ");
        int num3 = getInput(sc, "Enter the third number: ");

        // Calculate maximum
        int max = findMaximum(num1, num2, num3);

        // Display result
        System.out.println("The maximum of the three numbers is: " + max);
	// Closing scanner class
        scanner.close();
    }

    // Method to get input from the user
    public static int getInput(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Method to find the maximum of three integers
    public static int findMaximum(int a, int b, int c)
    {
        int max = a;

        if (b > max) 
	{
            max = b;
        }
        if (c > max) 
	{
            max = c;
        }

        return max;
    }
}
