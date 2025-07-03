// Interface for reservable items
interface Reservable 
{
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract base class
abstract class LibraryItem 
{
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable = true;
    private String borrower; // sensitive data

    // Constructor
    public LibraryItem(String itemId, String title, String author)
    {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters (encapsulation)
    public String getItemId()
    {
        return itemId;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    protected boolean getAvailability()
    {
        return isAvailable;
    }

    protected void setAvailability(boolean status)
    {
        this.isAvailable = status;
    }

    protected String getBorrower()
    {
        return borrower;
    }

    protected void setBorrower(String borrower)
    {
        this.borrower = borrower;
    }

    // Concrete method
    public void getItemDetails()
    {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Reserved by " + borrower));
    }

    // Abstract method
    public abstract int getLoanDuration(); // in days
}

// Subclass: Book
class Book extends LibraryItem implements Reservable 
{
    public Book(String itemId, String title, String author)
    {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration()
    {
        return 21; // 3 weeks
    }

    @Override
    public void reserveItem(String borrowerName)
    {
        if (checkAvailability()) 
	{
            setBorrower(borrowerName);
            setAvailability(false);
            System.out.println("Book reserved for: " + borrowerName);
        } 
	else 
	{
            System.out.println("Book is currently not available.");
        }
    }

    @Override
    public boolean checkAvailability()
    {
        return getAvailability();
    }
}

// Subclass: Magazine
class Magazine extends LibraryItem implements Reservable 
{
    public Magazine(String itemId, String title, String author)
    {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration()
    {
        return 7; // 1 week
    }

    @Override
    public void reserveItem(String borrowerName)
    {
        if (checkAvailability())
	{
            setBorrower(borrowerName);
            setAvailability(false);
            System.out.println("Magazine reserved for: " + borrowerName);
        } 
	else 
	{
            System.out.println("Magazine is currently not available.");
        }
    }

    @Override
    public boolean checkAvailability()
    {
        return getAvailability();
    }
}

// Subclass: DVD
class DVD extends LibraryItem implements Reservable 
{
    public DVD(String itemId, String title, String author)
    {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration()
    {
        return 14; // 2 weeks
    }

    @Override
    public void reserveItem(String borrowerName)
    {
        if (checkAvailability()) 
	{
            setBorrower(borrowerName);
            setAvailability(false);
            System.out.println("DVD reserved for: " + borrowerName);
        } 
	else 
	{
            System.out.println("DVD is currently not available.");
        }
    }

    @Override
    public boolean checkAvailability()
    {
        return getAvailability();
    }
}

// Driver class
public class LibraryManagement 
{
    public static void main(String... args)
    {
        LibraryItem item1 = new Book("B001", "The Alchemist", "Paulo Coelho");
        LibraryItem item2 = new Magazine("M001", "National Geographic", "Editorial Team");
        LibraryItem item3 = new DVD("D001", "Inception", "Christopher Nolan");

        // Polymorphism in action
        LibraryItem[] items = { item1, item2, item3 };
        for (LibraryItem item : items) 
	{
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Cast to Reservable
            if (item instanceof Reservable)
	    {
                Reservable resItem = (Reservable) item;
                resItem.reserveItem("John Doe");
            }

        }
    }
}
