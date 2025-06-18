// Importing Scanner class from util package
import java.util.Scanner;
// Display calendar of a year with respect to month and year input by the user
public class CalendarDisplay 
{

    // Array of month names
    static String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    // Number of days in each month
    static int[] daysInMonth = {
            0, 31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };

    // Check for leap year
    public static boolean isLeapYear(int year)
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Zeller's congruence to find first day of month (0=Sun,...,6=Sat)
    public static int getStartDay(int year, int month)
    {
        if (month < 3) 
	{
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        return (1 + 13 * (month + 1) / 5 + k + k/4 + j/4 + 5 * j) % 7;
    }

    public static void printCalendar(int month, int year)
    {
        int days = daysInMonth[month];
        if (month == 2 && isLeapYear(year)) days = 29;

        int startDay = getStartDay(year, month);
        startDay = (startDay + 6) % 7; // Adjust to make 0 = Sunday

        System.out.printf("\n  %s %d\n", months[month], year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Pad spaces for the first week
        for (int i = 0; i < startDay; i++) 
	{
            System.out.print("    ");
        }

        // Print days of the month
        for (int day = 1; day <= days; day++) 
	{
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0) System.out.println(); // New line after Saturday
        }
        System.out.println(); // Final new line
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input month and year from the user
        int month = sc.nextInt();
        int year = sc.nextInt();

        printCalendar(month, year);
	// Closing scanner class
	sc.close();
    }
}
