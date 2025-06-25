// Define a class to register a vehicle
public class Vehicle 
{
    // Initialize variables to store data
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000.0; // fixed for all vehicles

    // Constructor
    Vehicle(String ownerName, String vehicleType)
    {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    void displayVehicleDetails()
    {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    // Class method to update registration fee
    static void updateRegistrationFee(double fee)
    {
        registrationFee = fee;
    }

    // Main method to test
    public static void main(String... args)
    {
        Vehicle v1 = new Vehicle("Alice", "Two-Wheeler");
        Vehicle v2 = new Vehicle("Bob", "Four-Wheeler");

        System.out.println("Vehicle 1 Details:");
        v1.displayVehicleDetails();

        System.out.println("\nVehicle 2 Details:");
        v2.displayVehicleDetails();

        // Updating registration fee
        Vehicle.updateRegistrationFee(6000.0);

        System.out.println("\nAfter Updating Registration Fee:");

        System.out.println("\nVehicle 1 Details:");
        v1.displayVehicleDetails();

        System.out.println("\nVehicle 2 Details:");
        v2.displayVehicleDetails();
    }
}