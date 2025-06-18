// Importing Scanner class from util package
import java.util.Scanner;
// Convert various units of length into one another
public class ExtendedUnitConverter
{

    // Convert yards to feet
    public static double convertYardsToFeet(double yards)
    {
        return yards * 3;
    }

    // Convert feet to yards
    public static double convertFeetToYards(double feet)
    {
        return feet * 0.333333;
    }

    // Convert meters to inches
    public static double convertMetersToInches(double meters)
    {
        return meters * 39.3701;
    }

    // Convert inches to meters
    public static double convertInchesToMeters(double inches)
    {
        return inches * 0.0254;
    }

    // Convert inches to centimeters
    public static double convertInchesToCentimeters(double inches)
    {
        return inches * 2.54;
    }

    public static void main(String... args) 
    {
	// Creating object of Scanner class
        Scanner sc = new Scanner(System.in);
        // Conversions
        double yards = 5;
        double feet = 10;
        double meters = 1;
        double inches = 12;
	// Displaying result
        System.out.println(yards + " yards = " + convertYardsToFeet(yards) + " feet");
        System.out.println(feet + " feet = " + convertFeetToYards(feet) + " yards");
        System.out.println(meters + " meters = " + convertMetersToInches(meters) + " inches");
        System.out.println(inches + " inches = " + convertInchesToMeters(inches) + " meters");
        System.out.println(inches + " inches = " + convertInchesToCentimeters(inches) + " cm");
	// Closing scanner class
	sc.close();
    }
}
