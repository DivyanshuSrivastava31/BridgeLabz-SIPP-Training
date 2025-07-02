// Define a class to show Transport management system
// Base class: Vehicle
class Vehicle
{
    double maxSpeed;
    String fuelType;

    public Vehicle(double maxSpeed, String fuelType)
    {
        this.maxSpeed=maxSpeed;
	this.fuelType=fuelType;
    }

    // Method to display Vehicle details
    public void displayInfo()
    {
        System.out.println("Maximum speed of the vehicle : "+maxSpeed);
	System.out.println("Fuel type of the vehicle : "+fuelType);
    }
}

// Sub class : Car
class Car extends Vehicle
{
	int seatCapacity;
	public Car(double maxSpeed, String fuelType, int seatCapacity)
	{
		this.maxSpeed=maxSpeed;
		this.fuelType=fuelType;
		this.seatCapacity=seatCapacity;
	}
	// Method to display Vehicle details
 	public void displayInfo()
 	{
		System.out.println("Maximum speed of the vehicle : "+maxSpeed);
		System.out.println("Fuel type of the vehicle : "+fuelType);
		System.out.println("Seat capacity of the vehicle : "+seatCapacity);
	}
}

// Sub class : Truck
class Truck extends Vehicle
{
	double loadCapacity;
	public Truck(double maxSpeed, String fuelType, double loadCapacity)
	{
		this.maxSpeed=maxSpeed;
		this.fuelType=fuelType;
		this.loadCapacity=loadCapacity;
	}
	// Method to display Vehicle details
 	public void displayInfo()
 	{
		System.out.println("Maximum speed of the vehicle : "+maxSpeed);
		System.out.println("Fuel type of the vehicle : "+fuelType);
		System.out.println("Load capacity of the vehicle : "+loadCapacity);
	}
	
}

// Sub class : Motorcycle
class Motorcycle extends Vehicle
{
	int horsePower;
	public MotorCycle(double maxSpeed, String fuelType, int horsePower)
	{
		this.maxSpeed=maxSpeed;
		this.fuelType=fuelType;
		this.horsePower=horsePower;
	}
	// Method to display Vehicle details
 	public void displayInfo()
 	{
		System.out.println("Maximum speed of the vehicle : "+maxSpeed);
		System.out.println("Fuel type of the vehicle : "+fuelType);
		System.out.println("Horse Power of the vehicle : "+horsePower);
	}
}

// Main class
public class TransportManagement
{
	public static void main(String... args)
	{
		Car car=new Car(105.0,"Diesel",7);
		Truck truck=new Truck(95.5,"Petrol",65.9);
		Motorcycle motorcycle=new Motorcycle(100.0,"Diesel",2000);
		System.out.println("Car Details : ");
		car.displayInfo();
		System.out.println("Truck Details : ");
		truck.displayInfo();
		System.out.println("Motorcycle Details : ");
		motorcycle.displayInfo();
	}
}


