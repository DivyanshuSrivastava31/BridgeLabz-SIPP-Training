// Importing LocalDate and DateTimeFormatter class from time package
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// Importing Scanner class from util package
import java.util.Scanner;
// Check if the first date is before, after, or the same as the second date
public class DateComparison 
{
    public static void main(String... args)
    {
        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Define date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try 
	{
            // Take first date input from user
            String firstInput = sc.nextLine();
            LocalDate firstDate = LocalDate.parse(firstInput, formatter);

            // Take second date input from user
            String secondInput = sc.nextLine();
            LocalDate secondDate = LocalDate.parse(secondInput, formatter);

            // Compare dates using LocalDate methods
            if (firstDate.isBefore(secondDate))
	    {
                System.out.println("The first date is before the second date.");
            } 
	    else if (firstDate.isAfter(secondDate))
	    {
                System.out.println("The first date is after the second date.");
            }
	    else
	    {
                System.out.println("Both dates are the same.");
            }

        } 
	catch (Exception e) 
	{
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
        }

        // Close the scanner
        sc.close();
    }
}
