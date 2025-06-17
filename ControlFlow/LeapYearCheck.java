// Importing Scanner class from util package
import java.util.Scanner;
// Check whether a year is Leap year or not using multiple ifs
public class LeapYearCheck {
    public static void main(String.. args) {
        // Creating object of scanner class
	Scanner sc = new Scanner(System.in);

        // Input the year from the user
        int year = sc.nextInt();

        // Check if year is in the Gregorian calendar
        if (year < 1582) {
            System.out.println("The year " + year + " is not in the Gregorian calendar (year must be >= 1582).");
        } else {
            // Check leap year conditions using multiple if-else
            if (year % 400 == 0) {
                System.out.println("The year " + year + " is a Leap Year.");
            } else if (year % 100 == 0) {
                System.out.println("The year " + year + " is Not a Leap Year.");
            } else if (year % 4 == 0) {
                System.out.println("The year " + year + " is a Leap Year.");
            } else {
                System.out.println("The year " + year + " is Not a Leap Year.");
            }
        }
	// Closing scanner class
        sc.close();
    }
}
