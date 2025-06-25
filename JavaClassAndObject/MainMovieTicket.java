// Importing scanner class from util package
import java.util.Scanner
// Main class to define the object of MovieTicket class
public class MainMovieTicket
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking movie name, seat number of hall and price of ticket from the user
		String movieName=sc.nextLine();
		String seatNumber=sc.nextLine();
		int price=sc.nextInt();
		// Creating object and calling method to display the result
		MovieTicket objTicket = new MovieTicket(movieName, seatNumber, price);
		objTicket.displayDetails();
		
		// Closing object of scanner class
		sc.close();
	}
}