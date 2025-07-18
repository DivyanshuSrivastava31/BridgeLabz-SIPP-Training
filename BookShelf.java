import java.util.*;

// Book class
class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Override equals and hashCode for proper HashSet behavior
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        return title.equals(other.title) && author.equals(other.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

// Library Organizer
class BookShelf {
    // genre -> list of books
    private Map<String, LinkedList<Book>> genreMap;
    // global set to prevent duplicates
    private Set<Book> bookSet;

    public BookShelf() {
        genreMap = new HashMap<>();
        bookSet = new HashSet<>();
    }

    // Add a book to the shelf
    public void addBook(String genre, Book book) {
        if (bookSet.contains(book)) {
            System.out.println(book + " already exists in the library.");
            return;
        }

        genreMap.putIfAbsent(genre, new LinkedList<>());
        genreMap.get(genre).add(book);
        bookSet.add(book);
        System.out.println("Added " + book + " to " + genre + " section.");
    }

    // Borrow (remove) a book from the shelf
    public void borrowBook(String genre, Book book) {
        LinkedList<Book> books = genreMap.get(genre);
        if (books != null && books.remove(book)) {
            bookSet.remove(book);
            System.out.println("Borrowed " + book + " from " + genre + " section.");
        } else {
            System.out.println(book + " not found in " + genre + " section.");
        }
    }

    // Return a book to the shelf
    public void returnBook(String genre, Book book) {
        addBook(genre, book); // Reuse addBook logic
    }

    // Display the full catalog
    public void displayCatalog() {
        System.out.println("\nLibrary Catalog:");
        for (String genre : genreMap.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book book : genreMap.get(genre)) {
                System.out.println("  - " + book);
            }
        }
    }
}

// Main class to test
public class LibrarySystem {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();

        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("The Silmarillion", "J.R.R. Tolkien");
        Book b4 = new Book("The Hobbit", "J.R.R. Tolkien"); // duplicate

        shelf.addBook("Fantasy", b1);
        shelf.addBook("Dystopian", b2);
        shelf.addBook("Fantasy", b3);
        shelf.addBook("Fantasy", b4); // should be prevented

        shelf.displayCatalog();

        shelf.borrowBook("Fantasy", b1);
        shelf.displayCatalog();

        shelf.returnBook("Fantasy", b1);
        shelf.displayCatalog();
    }
}
