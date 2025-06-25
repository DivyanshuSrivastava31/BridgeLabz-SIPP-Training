// Define a class to simulate a car rental system
public class CarRental 
{ 
    // Initialize  variables to store data
    String customerName;
    String carModel;
    int rentalDays;

    // Assume a fixed daily rental rate for simplicity
    static final double DAILY_RATE = 1500.0;

    // Default constructor
    CarRental() 
    {
        this.customerName = "Guest";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays)
    {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total cost
    double calculateTotalCost()
    {
        return DAILY_RATE * rentalDays;
    }

    // Method to display rental details
    void displayRentalDetails()
    {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    // Main method to test
    public static void main(String... args)
    {
        // Default booking
        CarRental rental1 = new CarRental();

        // Parameterized booking
        CarRental rental2 = new CarRental("John", "Toyota Fortuner", 4);

        System.out.println("Default Rental:");
        rental1.displayRentalDetails();

        System.out.println("\nCustom Rental:");
        rental2.displayRentalDetails();
    }
}