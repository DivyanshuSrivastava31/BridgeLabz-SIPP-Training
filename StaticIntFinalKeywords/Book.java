// Define a class to manage library books
public class Book
{
	// Initialize variables to store data
	private String title;
	private String author;
	// Finalize ISBN number of the object
	private final long isbn;
	// Static variable to store library name
	static String library="Oxford Central Library";
	// Method to display library name
	static void libraryName()
	{
		System.out.println("Library Name : "+library);
	}
	// Define a constructor to retrieve data
	public Book(String title, String author, long isbn)
	{
		this.title=title;
		this.author=author;
		this.isbn=isbn;
	}
	// Method to display details of the book
	void displayDetails()
	{
		if(this instanceof Book)
		{
			System.out.println("Book Details : ");
			System.out.println("Title of the book : "+this.title);
			System.out.println("Author of the book : "+this.author);
			System.out.println("ISBN number of the book : "+this.isbn);
		}
		else
		{
			System.out.println("Invalid object of the class");
		}
	}
	// Main method
	public static void main(String... args)
	{
		Book book1 = new Book("Can't Hurt Me", "David Goggins", 7009827910);
		Book book2 = new Book("Tom Swayer","Mark Twain",400003203);
		// Display details
		book1.libraryName();
		book1.displayDetails();
		book2.libraryName();
		book2.displayDetails();
	}
}