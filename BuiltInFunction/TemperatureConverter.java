// Importing scanner class from util package
import java.util.Scanner;
// Convert temperatures between Fahrenheit and Celsius
public class TemperatureConverter 
{

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Display menu to user
        System.out.println("Temperature Converter");
        System.out.println("1. Convert Fahrenheit to Celsius");
        System.out.println("2. Convert Celsius to Fahrenheit");
        System.out.print("Choose an option (1 or 2): ");
        int choice = sc.nextInt();

        // Handle user's choice
        switch (choice) 
	{
            case 1:
                System.out.print("Enter temperature in Fahrenheit: ");
                double fahrenheit = scanner.nextDouble();
                double celsiusResult = fahrenheitToCelsius(fahrenheit);
                System.out.printf("Temperature in Celsius: %.2f°C\n", celsiusResult);
                break;

            case 2:
                System.out.print("Enter temperature in Celsius: ");
                double celsius = scanner.nextDouble();
                double fahrenheitResult = celsiusToFahrenheit(celsius);
                System.out.printf("Temperature in Fahrenheit: %.2f°F\n", fahrenheitResult);
                break;

            default:
                System.out.println("Invalid option. Please enter 1 or 2.");
        }
	// Closing scanner class
        sc.close();
    }

    // Function to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double f)
    {
        return (f - 32) * 5 / 9;
    }

    // Function to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double c)
    {
        return (c * 9 / 5) + 32;
    }
}
