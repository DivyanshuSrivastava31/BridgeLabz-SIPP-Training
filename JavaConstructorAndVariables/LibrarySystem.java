// Define a class to access a book
class Book 
{
    // Initialize variables to store data
    public String ISBN;         // public - accessible everywhere
    protected String title;     // protected - accessible in subclass
    private String author;      // private - only within this class

    // Constructor
    public Book(String ISBN, String title, String author)
    {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public getter for author
    public String getAuthor()
    {
        return author;
    }

    // Public setter for author
    public void setAuthor(String author)
    {
        this.author = author;
    }

    // Display method
    public void displayDetails()
    {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Define a class to access an e-book
class EBook extends Book 
{
    // Initialize variables to store data
    private double fileSizeMB;

    public EBook(String ISBN, String title, String author, double fileSizeMB)
    {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public void displayEBookDetails() 
    {
        // Accessing public and protected members from parent
        System.out.println("E-Book ISBN: " + ISBN);    // public
        System.out.println("E-Book Title: " + title);  //protected
        System.out.println("E-Book File Size: " + fileSizeMB + "MB");

        // Accessing private member via public method
        System.out.println("Author: " + getAuthor());  //via getter
    }
}

// Define class to simulate library system
public class LibrarySystem 
{
    public static void main(String[] args) 
    {
        Book book = new Book("1234-345", "Effective Java", "Joshua Bloch");
        book.displayDetails();

        System.out.println("\n--- EBook Details ---");
        EBook ebook = new EBook("12-456", "Java: The Complete Reference", "Herbert Schildt", 5.8);
        ebook.displayEBookDetails();

        // Update author using setter
        ebook.setAuthor("H. Schildt");
        System.out.println("\nAfter updating author:");
        System.out.println("New Author: " + ebook.getAuthor());
    }
}