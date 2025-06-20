// Importing scanner class from util package
import java.util.Scanner;
// Calculate GCD and LCM of two numbers given by the user
public class GCDandLCMCalculator 
{

    public static void main(String... args)
    {
        // Take input from the user
        int num1 = getInput("Enter the first number: ");
        int num2 = getInput("Enter the second number: ");

        // Calculate GCD and LCM using functions
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);

        // Display the results
        displayResults(num1, num2, gcd, lcm);
    }

    // Function to get input
    public static int getInput(String prompt)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        int number = scanner.nextInt();
	// Closing scanner class
	sc.close();
        return number;
    }

    // Function to calculate GCD using Euclidean algorithm
    public static int calculateGCD(int a, int b)
    {
        while (b != 0) 
	{
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM using the formula: LCM = (a * b) / GCD
    public static int calculateLCM(int a, int b, int gcd)
    {
        return (a * b) / gcd;
    }

    // Function to display the result
    public static void displayResults(int a, int b, int gcd, int lcm)
    {
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }
}
