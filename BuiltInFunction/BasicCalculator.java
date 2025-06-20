// Importing scanner class from util package
import java.util.Scanner;
// Compute a basic calculator with basic arithematic operations
public class BasicCalculator 
{

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Display menu
        System.out.println("Basic Calculator");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choose an operation (1-4): ");
        int choice = sc.nextInt();

        // Get two numbers from the user
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();

        // Perform the selected operation
        switch (choice) 
	{
            case 1:
                System.out.println("Result: " + add(num1, num2));
                break;
            case 2:
                System.out.println("Result: " + subtract(num1, num2));
                break;
            case 3:
                System.out.println("Result: " + multiply(num1, num2));
                break;
            case 4:
                if (num2 != 0) 
	 	{
                    System.out.println("Result: " + divide(num1, num2));
                } 
		else 
		{
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please select between 1 and 4.");
        }
	// Closing scanner class
        sc.close();
    }

    // Function to add two numbers
    public static double add(double a, double b)
    {
        return a + b;
    }

    // Function to subtract two numbers
    public static double subtract(double a, double b)
    {
        return a - b;
    }

    // Function to multiply two numbers
    public static double multiply(double a, double b)
    {
        return a * b;
    }

    // Function to divide two numbers
    public static double divide(double a, double b)
    {
        return a / b;
    }
}
