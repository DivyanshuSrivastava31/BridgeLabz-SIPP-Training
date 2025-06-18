// Importing Scanner class from util package
import java.util.Scanner;
// Compute the number of rounds to complete in 5 km in Triangluar Park
public class TriangularPark 
{

    // Method to calculate the number of rounds to complete 5km
    public static double calculateRounds(double side1, double side2, double side3) 
    {
        double perimeter = side1 + side2 + side3;
        double totalDistanceMeters = 5000.0;
        return totalDistanceMeters / perimeter;
    }

    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input 3 sides of triangle in meters from the user
        double side1 = sc.nextDouble();

        double side2 = sc.nextDouble();

        double side3 = sc.nextDouble();

        // Calculate number of rounds
        double rounds = calculateRounds(side1, side2, side3);

        // Display result rounded up
        System.out.printf("Number of rounds required to complete 5 km run: ", rounds);
	// Closing scanner class
	sc.close();
    }
}
