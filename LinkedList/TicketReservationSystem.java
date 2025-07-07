// Node class representing a booked ticket
class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Circular Linked List for managing ticket reservations
public class TicketReservationSystem {
    TicketNode head = null;
    TicketNode tail = null;

    // 1. Add a new ticket reservation at the end
    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully for " + customerName);
    }

    // 2. Remove a ticket by Ticket ID
    void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = head;
        TicketNode prev = tail;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Ticket ID " + ticketId + " removed successfully.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found)
            System.out.println("Ticket ID not found.");
    }

    // 3. Display all current tickets
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("Current Booked Tickets:");
        TicketNode current = head;
        int count = 1;
        do {
            System.out.println(count++ + ". Ticket ID: " + current.ticketId);
            System.out.println("   Customer: " + current.customerName);
            System.out.println("   Movie: " + current.movieName);
            System.out.println("   Seat: " + current.seatNumber);
            System.out.println("   Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // 4. Search for a ticket by Customer Name or Movie Name
    void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket Found:");
                System.out.println("Ticket ID: " + current.ticketId);
                System.out.println("Customer: " + current.customerName);
                System.out.println("Movie: " + current.movieName);
                System.out.println("Seat: " + current.seatNumber);
                System.out.println("Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found)
            System.out.println("No ticket found with keyword: " + keyword);
    }

    // 5. Calculate total number of booked tickets
    int countTickets() {
        if (head == null) return 0;

        int count = 0;
        TicketNode current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    // Main method to test the system
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Booking tickets
        system.addTicket(101, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Bob", "Interstellar", "B2", "11:00 AM");
        system.addTicket(103, "Charlie", "Inception", "C3", "12:00 PM");

        // Display all tickets
        System.out.println();
        system.displayTickets();

        // Search by customer or movie
        System.out.println();
        system.searchTicket("Alice");
        system.searchTicket("Interstellar");

        // Remove a ticket
        System.out.println();
        system.removeTicket(102);

        // Display after removal
        System.out.println();
        system.displayTickets();

        // Count total tickets
        System.out.println("\nTotal Booked Tickets: " + system.countTickets());
    }
}
