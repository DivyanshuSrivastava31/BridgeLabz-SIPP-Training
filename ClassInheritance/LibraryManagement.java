// Importing scanner class from util package
import java.util.Scanner;
// Defining a class to store details of a book
class Book
{
	String bookTitle;
	int publicationYear;
}

// Defining a class to store details of the author
class Author extends Book // Single inheritance
{
	String authorName;
	String authorBio;
	public Author(String title, int year, String authName, String authBio)
	{
		bookTitle=title;
		publicationYear=year;
		authorName=authName;
		authorBio=authBio;
	}
	void displayInfo()
	{
		System.out.println("Book Details : ");
		System.out.println("Book title : "+bookTitle);
		System.out.println("Publication Year : "+publicationYear);
		System.out.println("Author Name : "+authorName);
		System.out.println("Author Biography : "+authorBio);
	}
}

//  Defining Main class
public class LibraryManagement
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Input values from the user
		System.out.println("Enter book title, book publication year, author name and author biography : ");
		String title=sc.nextLine();
		int publicationYear=sc.nextInt();
		String name=sc.nextLine();
		String bio=sc.nextLine();
		// Object creating and method calling
		Author author=new Author(title,publicationYear,name,bio);
		author.displayInfo();
	}
}