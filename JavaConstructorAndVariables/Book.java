// Define a class to define a book
public class Book
{
    // Initialize variables to store data
    String title;
    String author;
    double price;
    
    //default constructor
    Book() 
    {
        title = "Tom Swayer";
	author = "Mark Twain";
	price = 400.0;  
    }
    
    //parameterized constructor
    Book(String title, String author, double price)
    {
        this.title = title;
	this.author = author;
	this.price = price;
    }
    
    // Display Order Details
    void displayBookDetails() {
        System.out.println("Book Title:- " + title);
        System.out.println("Book Author:- " + author);
        System.out.println("Price:- " + price);
    }

    // Main method 
    public static void main(String... args)
    {
        Book book1 = new Book();
	Book book2 = new Book("Can't Hurt Me", "David Goggins", 700.0);
	
	System.out.println("Default Constructor call: ");
	book1.displayBookDetails();
	
        System.out.println();
	
        System.out.println("Parameterized Constructor call: ");
	book2.displayBookDetails();
     }
}