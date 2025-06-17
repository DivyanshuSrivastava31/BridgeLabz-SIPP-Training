// Importing Scanner Class from util package
import java.util.Scanner;
// Check whether a year is Leap Year or not
public class LeapYear {
    public static void main(String... args) {
	// Creating object of Scanner class
        Scanner sc = new Scanner(System.in);

        // Take year input from the user
        int year = sc.nextInt();

        // Check if the year is in the Gregorian calendar
        if (year >= 1582) {
            // Check for leap year 
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println("The year " + year + " is a Leap Year.");
            } else {
                System.out.println("The year " + year + " is Not a Leap Year.");
            }
        } else {
            System.out.println("The year " + year + " is not in the Gregorian calendar");
        }
	// Closing scanner class
        sc.close();
    }
}