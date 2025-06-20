// Importing LocalDate class from time package
import java.time.LocalDate;
// Importing Scanner class from util package
import java.util.Scanner;
// Adds 7 days, 1 month, and 2 years to date input, then subtracts 3 weeks from the result
public class DateArithmetic 
{
    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Take date input from user in format YYYY-MM-DD
        String input = sc.nextLine();

        // Parse the input date
        LocalDate date = LocalDate.parse(input);

        // Add 7 days, 1 month, and 2 years
        LocalDate addedDate = date.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks (21 days)
        LocalDate finalDate = addedDate.minusWeeks(3);

        // Display results
        System.out.println("Original Date      : " + date);
        System.out.println("After Addition     : " + addedDate);
        System.out.println("After Subtracting 3 Weeks: " + finalDate);
	// Closing scanner class
        sc.close();
    }
}
