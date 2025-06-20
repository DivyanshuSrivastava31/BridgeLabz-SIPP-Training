// Importing LocalDate and DateTimeFormatter class using time package
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// Display the current date in three different formats
public class DateFormattingExample 
{
    public static void main(String... args)
    {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the three format patterns
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Format and display the date in different formats
        System.out.println("Format 1 (dd/MM/yyyy): " + currentDate.format(format1));
        System.out.println("Format 2 (yyyy-MM-dd): " + currentDate.format(format2));
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + currentDate.format(format3));
    }
}
