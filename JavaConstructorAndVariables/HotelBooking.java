// Define a class to simulate hotel booking system
public class HotelBooking 
{
    // Initialize variables to store data
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() 
    {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) 
    {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking booking) 
    {
        this.guestName = booking.guestName;
        this.roomType = booking.roomType;
        this.nights = booking.nights;
    }

    // Method to display booking details
    void displayBooking() 
    {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    // Main method to test
    public static void main(String... args) 
    {
        // Default constructor
        HotelBooking booking1 = new HotelBooking();

        // Parameterized constructor
        HotelBooking booking2 = new HotelBooking("John", "Deluxe", 3);

        // Copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);

        System.out.println("Default Booking:");
        booking1.displayBooking();

        System.out.println("\nParameterized Booking:");
        booking2.displayBooking();

        System.out.println("\nCopied Booking:");
        booking3.displayBooking();
    }
}