import java.util.*;

class Flight {
    String flightNumber;
    String origin;
    String destination;

    Flight(String flightNumber, String origin, String destination) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
    }

    public String toString() {
        return "Flight No: " + flightNumber + ", From: " + origin + ", To: " + destination;
    }
}

class Booking {
    String passengerName;
    Flight flight;

    Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public String toString() {
        return "Passenger: " + passengerName + ", " + flight.toString();
    }
}

public class Main {
    static Flight[] flights = {
        new Flight("AI101", "Delhi", "Mumbai"),
        new Flight("AI202", "Bangalore", "Chennai"),
        new Flight("AI303", "Delhi", "Chennai"),
        new Flight("AI404", "Mumbai", "Kolkata")
    };

    static List<Booking> bookings = new ArrayList<>();

    // Search flights
    public static void searchFlights(String from, String to) {
        boolean found = false;
        System.out.println("\nAvailable Flights:");
        for (Flight f : flights) {
            if (f.origin.equalsIgnoreCase(from) && f.destination.equalsIgnoreCase(to)) {
                System.out.println(f);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found.");
        }
    }

    // Book a flight
    public static void bookFlight(String flightNumber, String passengerName) {
        for (Flight f : flights) {
            if (f.flightNumber.equalsIgnoreCase(flightNumber)) {
                bookings.add(new Booking(passengerName, f));
                System.out.println("Booking successful for " + passengerName);
                return;
            }
        }
        System.out.println("Flight not found.");
    }

    // Display all bookings
    public static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings yet.");
        } else {
            System.out.println("\nYour Bookings:");
            for (Booking b : bookings) {
                System.out.println(b);
            }
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Flight Booking System ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter origin: ");
                    String from = sc.nextLine();
                    System.out.print("Enter destination: ");
                    String to = sc.nextLine();
                    searchFlights(from, to);
                    break;
                case 2:
                    System.out.print("Enter flight number to book: ");
                    String flightNo = sc.nextLine();
                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();
                    bookFlight(flightNo, name);
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
