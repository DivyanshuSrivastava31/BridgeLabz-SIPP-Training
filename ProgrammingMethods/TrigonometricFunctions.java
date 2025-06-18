import java.util.Scanner;

//Importing Scanner class from util package
import java.util.Scanner;
//Compute trigonometric equations on an angle in radians
public class TrigonometricFunctions {

    // Method to calculate sine, cosine, and tangent
    public static double[] calculateTrigonometricFunctions(double angle) 
    {
        // Convert degrees to radians
	double radians = Math.toRadians(angle); 

        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
	// Return all in array
        return new double[]{sine, cosine, tangent}; 
    }

    public static void main(String... args) 
    {
	//Creating Object Of Scanner class
        Scanner scanner = new Scanner(System.in);

        // Get angle input from the user
        double angle = scanner.nextDouble();

        // Call method and get result
        double[] results = calculateTrigonometricFunctions(angle);

        // Display results
        System.out.println("Sine of " + angle + "° = " + results[0]);
        System.out.println("Cosine of " + angle + "° = " + results[1]);
        System.out.println("Tangent of " + angle + "° = " + results[2]);
	//Closing Scanner class
        scanner.close();
    }
}
