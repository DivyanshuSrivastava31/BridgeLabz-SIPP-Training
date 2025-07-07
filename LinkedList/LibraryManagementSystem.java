// Node class
class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next, prev;

    public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class
public class LibraryManagementSystem {
    BookNode head, tail;

    // Count total number of books
    int getCount() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Add at beginning
    void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode book = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = book;
        } else {
            book.next = head;
            head.prev = book;
            head = book;
        }
    }

    // Add at end
    void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode book = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = book;
        } else {
            tail.next = book;
            book.prev = tail;
            tail = book;
        }
    }

    // Add at a specific position (1-based)
    void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        if (position > getCount() + 1) {
            System.out.println("Invalid position entered");
            return;
        }

        BookNode book = new BookNode(title, author, genre, bookId, isAvailable);
        BookNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        book.next = current.next;
        if (current.next != null) {
            current.next.prev = book;
        } else {
            tail = book; // if inserted at the end
        }
        book.prev = current;
        current.next = book;
    }

    // Remove by Book ID
    void removeByBookId(int bookId) {
        BookNode current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Book with ID " + bookId + " removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book ID not found.");
    }

    // Search by title or author
    void searchBook(String title, String author) {
        BookNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title) || current.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found:");
                System.out.println("Title: " + current.title);
                System.out.println("Author: " + current.author);
                System.out.println("Genre: " + current.genre);
                System.out.println("Book ID: " + current.bookId);
                System.out.println("Available: " + (current.isAvailable ? "Yes" : "No"));
            }
            current = current.next;
        }
    }

    // Update availability
    void updateAvailability(int bookId, boolean isAvailable) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Book availability updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book ID not found.");
    }

    // Display books forward
    void displayForward() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            System.out.println(count + ". Book Details:");
            System.out.println("Title: " + current.title);
            System.out.println("Author: " + current.author);
            System.out.println("Genre: " + current.genre);
            System.out.println("Book ID: " + current.bookId);
            System.out.println("Available: " + (current.isAvailable ? "Yes" : "No"));
            current = current.next;
        }
    }

    // Display books in reverse
    void displayReverse() {
        int count = 0;
        BookNode current = tail;
        while (current != null) {
            count++;
            System.out.println(count + ". Book Details:");
            System.out.println("Title: " + current.title);
            System.out.println("Author: " + current.author);
            System.out.println("Genre: " + current.genre);
            System.out.println("Book ID: " + current.bookId);
            System.out.println("Available: " + (current.isAvailable ? "Yes" : "No"));
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lib = new LibraryManagementSystem();

        lib.addAtBeginning("1984", "George Orwell", "Dystopian", 101, true);
        lib.addAtEnd("To Kill a Mockingbird", "Harper Lee", "Classic", 102, true);
        lib.addAtEnd("The Hobbit", "J.R.R. Tolkien", "Fantasy", 103, false);
        lib.addAtPosition("The Catcher in the Rye", "J.D. Salinger", "Classic", 104, true, 2);

        System.out.println("Books (Forward):");
        lib.displayForward();
        System.out.println();

        System.out.println("Books (Reverse):");
        lib.displayReverse();
        System.out.println();

        lib.searchBook("The Hobbit", "");
        System.out.println();

        lib.updateAvailability(103, true);
        lib.removeByBookId(102);
        System.out.println();

        System.out.println("Books After Update:");
        lib.displayForward();
        System.out.println("Total Books: " + lib.getCount());
    }
}
