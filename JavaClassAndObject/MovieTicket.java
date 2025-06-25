// Design a class to model movie booking system
public class MovieTicket
{
	// Initialize variables to store details
	private String movieName;
	private String seatNumber;
	private int price;
	// Declare a constructor to retrieve variable attributes
	public MovieTicket(String movieName, String seatNumber, int price)
	{
		this.movieName=movieName;
		this.seatNumber=seatNumber;
		this.price=price;
	}
	// Method to display details of the ticket
	public displayDetails()
	{
		System.out.println("Ticket Details : ");
		System.out.println("Name of the movie : "+this.movieName);	
		System.out.println("Seat of the movie hall : "+this.seatNumber);
		System.out.println("Price of the movie ticket : "+this.price);
	}
}