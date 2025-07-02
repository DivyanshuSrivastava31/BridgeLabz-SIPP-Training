import java.util.*;

// Custom Exception for invalid time format
class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

public class Main {

    static List<String> movieTitles = new ArrayList<>();
    static List<String> movieTimes = new ArrayList<>();

    // Validate time format (HH:mm)
    public static void validateTimeFormat(String time) throws InvalidTimeFormatException {
        if (!time.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
            throw new InvalidTimeFormatException("Invalid time format. Use HH:mm (e.g., 14:30).");
        }
    }

    // Add a movie with time
    public static void addMovie(String title, String time) throws InvalidTimeFormatException {
        validateTimeFormat(time);
        movieTitles.add(title);
        movieTimes.add(time);
        System.out.println("Movie added: " + title + " at " + time);
    }

    // Search movies by keyword
    public static void searchMovie(String keyword) {
        System.out.println("\nSearch results for '" + keyword + "':");
        boolean found = false;
        for (int i = 0; i < movieTitles.size(); i++) {
            if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(String.format("%d. %s - %s", i + 1, movieTitles.get(i), movieTimes.get(i)));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movies found.");
        }
    }

    // Display all movies
    public static void displayAllMovies() {
        if (movieTitles.isEmpty()) {
            System.out.println("No movies scheduled.");
            return;
        }

        System.out.println("\nAll Scheduled Movies:");
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(String.format("%d. %s - %s", i + 1, movieTitles.get(i), movieTimes.get(i)));
        }
    }

    // Convert List to Array and generate report
    public static void generateReport() {
        System.out.println("\n--- Movie Report ---");
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = movieTimes.toArray(new String[0]);

        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println((i + 1) + ". " + titlesArray[i] + " at " + timesArray[i]);
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- CinemaTime Movie Schedule Manager ---");
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movie");
            System.out.println("3. Display All Movies");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter movie title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter showtime (HH:mm): ");
                        String time = sc.nextLine();
                        addMovie(title, time);
                        break;
                    case 2:
                        System.out.print("Enter search keyword: ");
                        String keyword = sc.nextLine();
                        searchMovie(keyword);
                        break;
                    case 3:
                        displayAllMovies();
                        break;
                    case 4:
                        generateReport();
                        break;
                    case 5:
                        System.out.println("Exiting CinemaTime...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InvalidTimeFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: Invalid movie index.");
            }
        } while (choice != 5);

        sc.close();
    }
}
