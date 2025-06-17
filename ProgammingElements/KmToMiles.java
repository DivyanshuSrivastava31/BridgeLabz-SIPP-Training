//Importing Scanner class from util package
import java.util.Scanner;
//Converting distance in kilometers to distance in miles
public class KmToMiles {
    public static void main(String[] args) {
        // Declare a variable to store distance in kilometers
        double km;

        // Create Scanner object to take input from keyboard
        Scanner sc = new Scanner(System.in);

        // Taking  the input from user
        km = sc.nextInt();  // take input from user

        // 1 mile = 1.6 km, so miles = km / 1.6
        double miles = km / 1.6;

        // Display the result
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");

        // Close the scanner
        sc.close();
    }
}
