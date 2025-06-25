public class LibraryBook 
{
    String title;
    String author;
    double price;
    boolean isAvailable;

    // Parameterized constructor
    LibraryBook(String title, String author, double price, boolean isAvailable) 
    {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Method to borrow the book
    void borrowBook() 
    {
        if (isAvailable) 
        {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
        } 
        else {
            System.out.println("Sorry, the book \"" + title + "\" is currently not available.");
        }
    }

    // Method to display book details
    void displayBookDetails() 
    {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    // Main method to test
    public static void main(String[] args) 
    {
        LibraryBook book1 = new LibraryBook("The Alchemist", "Paulo Coelho", 350.0, true);
        LibraryBook book2 = new LibraryBook("1984", "George Orwell", 420.0, false);

        System.out.println("Book 1 Details:");
        book1.displayBookDetails();
        System.out.println();

        System.out.println("Book 2 Details:");
        book2.displayBookDetails();
        System.out.println();

        // Try borrowing both books
        System.out.println("Trying to borrow Book 1:");
        book1.borrowBook();

        System.out.println("\nTrying to borrow Book 2:");
        book2.borrowBook();

        System.out.println("\nUpdated Book 1 Details:");
        book1.displayBookDetails();
    }
}