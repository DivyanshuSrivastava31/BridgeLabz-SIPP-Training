// Importing Scanner class from util package
import java.util.Scanner;
// Check whether a year is leap year or not
public class LeapYearChecker 
{

    // Method to check if year is leap year
    public static boolean isLeapYear(int year) 
    {
        if (year < 1582)
            return false; // Only Gregorian calendar

        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input year from the user
        int year = sc.nextInt();

        // Display result
        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is Not a Leap Year.");
        }
	// Closing scanner class
	sc.close();
    }
}
