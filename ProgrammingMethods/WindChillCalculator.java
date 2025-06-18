// Importing Scanner class from util package
import java.util.Scanner;
// Compute chillness in wind using wind speed and temperature
public class WindChillCalculator 
{

    // Method to calculate wind chill temperature using formula
    public static double calculateWindChill(double temperature, double windSpeed) 
    {
        // Formula as per standard calculation
        return 35.74 + (0.6215 * temperature) 
               - (35.75 * Math.pow(windSpeed, 0.16)) 
               + (0.4275 * temperature * Math.pow(windSpeed, 0.16));
    }

    public static void main(String... args) 
    {
	// Creating object of Scanner class
        Scanner sc = new Scanner(System.in);

        // Input temperature and wind speed from the user

        double temperature = sc.nextDouble();

        double windSpeed = sc.nextDouble();

        // Calculate and display wind chill
        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.println("The wind chill temperature is: "+windChill+"°F");
	// Closing scanner class
	sc.close();
    }
}
