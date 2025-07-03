// Interface for GPS location tracking
interface GPS 
{
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract base class for vehicles
abstract class Vehicle 
{
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation; // for GPS tracking

    public Vehicle(String vehicleId, String driverName, double ratePerKm)
    {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Encapsulated getters
    public String getVehicleId()
    { 
	return vehicleId;
    }
    public String getDriverName()
    {
	return driverName;
    }
    public double getRatePerKm()
    { 
	return ratePerKm;
    }

    // Setter for location via GPS interface
    protected void setCurrentLocation(String location)
    {
        this.currentLocation = location;
    }

    protected String getLocation()
    {
        return currentLocation;
    }

    // Abstract method to be overridden
    public abstract double calculateFare(double distance);

    // Concrete method
    public String getVehicleDetails()
    {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/km: ₹" + ratePerKm;
    }
}

// Car implementation
class Car extends Vehicle implements GPS 
{
    public Car(String vehicleId, String driverName, double ratePerKm)
    {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance)
    {
        return getRatePerKm() * distance + 50; // base charge
    }

    public String getCurrentLocation()
    {
        return getLocation();
    }

    public void updateLocation(String newLocation)
    {
        setCurrentLocation(newLocation);
    }
}

// Bike implementation
class Bike extends Vehicle implements GPS 
{
    public Bike(String vehicleId, String driverName, double ratePerKm)
    {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance)
    {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation()
    {
        return getLocation();
    }

    public void updateLocation(String newLocation)
    {
        setCurrentLocation(newLocation);
    }
}

// Auto implementation
class Auto extends Vehicle implements GPS 
{
    public Auto(String vehicleId, String driverName, double ratePerKm)
    {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance)
    {
        return getRatePerKm() * distance + 20; // fixed surcharge
    }

    public String getCurrentLocation()
    {
        return getLocation();
    }

    public void updateLocation(String newLocation)
    {
        setCurrentLocation(newLocation);
    }
}

// Main class to demonstrate functionality
public class RideHailingApp 
{
    // Polymorphic method to process a ride
    public static void processRide(Vehicle v, double distance)
    {
        System.out.println(v.getVehicleDetails());
        if (v instanceof GPS)
 	{
            GPS gps = (GPS) v;
            gps.updateLocation("Pickup Point A");
            System.out.println("Current Location: " + gps.getCurrentLocation());
        }
        System.out.println("Fare for " + distance + " km: ₹" + v.calculateFare(distance));
    }

    public static void main(String... args)
    {
        Vehicle car = new Car("C001", "Arjun Mehta", 15);
        Vehicle bike = new Bike("B001", "Kavya Rao", 8);
        Vehicle auto = new Auto("A001", "Ravi Kumar", 10);

        processRide(car, 12.5);
        processRide(bike, 5.0);
        processRide(auto, 8.2);
    }
}
