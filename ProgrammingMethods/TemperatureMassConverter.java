// Importing Scanner class from util package
import java.util.Scanner;
// Converting various units of temperature into one another
public class TemperatureMassConverter 
{

    // Fahrenheit to Celsius
    public static double convertFahrenheitToCelsius(double f) 
    {
        return (f - 32) * 5 / 9;
    }

    // Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double c)
    {
        return (c * 9 / 5) + 32;
    }

    // Pounds to Kilograms
    public static double convertPoundsToKilograms(double pounds)
    {
        return pounds * 0.453592;
    }

    // Kilograms to Pounds
    public static double convertKilogramsToPounds(double kg)
    {
        return kg * 2.20462;
    }

    // Gallons to Liters
    public static double convertGallonsToLiters(double gallons)
    {
        return gallons * 3.78541;
    }

    // Liters to Gallons
    public static double convertLitersToGallons(double liters)
    {
        return liters * 0.264172;
    }

    public static void main(String... args)
    {
	//Creating object of scanner class
        Scanner sc = new Scanner(System.in);
        System.out.println("100°F = " + convertFahrenheitToCelsius(100) + "°C");
        System.out.println("37°C = " + convertCelsiusToFahrenheit(37) + "°F");
        System.out.println("150 pounds = " + convertPoundsToKilograms(150) + " kg");
        System.out.println("68 kg = " + convertKilogramsToPounds(68) + " pounds");
        System.out.println("10 gallons = " + convertGallonsToLiters(10) + " liters");
        System.out.println("5 liters = " + convertLitersToGallons(5) + " gallons");
	// Closing scanner class
	sc.close();
    }
}
