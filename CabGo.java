// Interface IRideService to define behaviour
interface IRideService 
{
    void bookRide(Vehicle vehicle, Driver driver, double distance);
    void endRide();
}

// Base abstract Vehicle class
abstract class Vehicle 
{
    private String vehicleNumber;
    private int capacity;
    private String type;

    public Vehicle(String vehicleNumber, int capacity, String type)
    {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public String getVehicleNumber()
    {
        return vehicleNumber;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public String getType()
    {
        return type;
    }

    public abstract double calculateFare(double distance);
}

// Mini class extending Vehicle
class Mini extends Vehicle 
{
    private static final double BASE_FARE = 30;
    private static final double RATE_PER_KM = 8;

    public Mini(String vehicleNumber, int capacity)
    {
        super(vehicleNumber, capacity, "Mini");
    }

    @Override
    public double calculateFare(double distance)
    {
        return BASE_FARE + distance * RATE_PER_KM;
    }
}

// Sedan class extending Vehicle
class Sedan extends Vehicle
{
    private static final double BASE_FARE = 50;
    private static final double RATE_PER_KM = 12;

    public Sedan(String vehicleNumber, int capacity)
    {
        super(vehicleNumber, capacity, "Sedan");
    }


    public double calculateFare(double distance)
    {
        return BASE_FARE + distance * RATE_PER_KM;
    }
}

// SUV class extending Vehicle
class SUV extends Vehicle 
{
    private static final double BASE_FARE = 70;
    private static final double RATE_PER_KM = 15;

    public SUV(String vehicleNumber, int capacity)
    {
        super(vehicleNumber, capacity, "SUV");
    }

    @Override
    public double calculateFare(double distance)
    {
        return BASE_FARE + distance * RATE_PER_KM;
    }
}

// Driver class
class Driver 
{
    private String name;
    private String licenseNumber;
    private double rating;

    public Driver(String name, String licenseNumber, double rating)
    {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public String getName()
    {
        return name;
    }

    public String getLicenseNumber()
    {
        return licenseNumber;
    }

    public double getRating()
    {
        return rating;
    }
}

// RideService implementation
class RideServiceImpl implements IRideService
{
    private Vehicle currentVehicle;
    private Driver currentDriver;
    private double distance;
    private double fare;

   
    public void bookRide(Vehicle vehicle, Driver driver, double distance)
    {
        this.currentVehicle = vehicle;
        this.currentDriver = driver;
        this.distance = distance;
        this.fare = vehicle.calculateFare(distance);

        System.out.println(" Ride booked with " + driver.getName() + " in a " + vehicle.getType());
        System.out.println(" Vehicle Number: " + vehicle.getVehicleNumber());
        System.out.println(" Estimated Fare: " + fare);
    }

    
    public void endRide()
    {
        System.out.println(" Ride ended. Please pay : " + fare);
        this.currentVehicle = null;
        this.currentDriver = null;
        this.distance = 0;
        this.fare = 0;
    }
}

// Main class
public class CabGo 
{
    public static void main(String... gs)
    {
        Vehicle mini = new Mini("UP80AB1234", 4);
        Vehicle sedan = new Sedan("UP82XY4567", 4);
        Vehicle suv = new SUV("UP83CD7890", 6);

        Driver driver = new Driver("Ravi Verma", "DL112233", 4.9);

        RideServiceImpl rideService = new RideServiceImpl();

        // Book a ride with Sedan
        rideService.bookRide(sedan, driver, 10.5);
        rideService.endRide();

        // Book another ride with SUV
        rideService.bookRide(suv, driver, 15.0);
        rideService.endRide();
    }
}