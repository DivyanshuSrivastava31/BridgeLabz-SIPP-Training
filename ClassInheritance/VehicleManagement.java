// Importing scanner class from util package
import java.util.Scanner;

// Implement an interface
interface Refeulable
{
	void refuel();
}

// Define a class vehicle
class Vehicle
{
	String model;
	double maxSpeed;
}

// Define sub-classes for petrol and electric vehicles
class PetrolVehicle extends Vehicle implements Refeulable 
{
	double volume;
	public PetrolVehicle(String model, double maxSpeed, double volume)
	{
		this.model=model;
		this.maxSpeed=maxSpeed;
		this.volume=volume;
	}
	public void refuel()
	{
		System.out.println("Vehicle details : ");
		System.out.println("Vehicle model : "+model);
		System.out.println("Vehicle Maximum Speed : "+maxSpeed);
		System.out.println("Fuel require for full tank : "+volume);
	}
}

class ElectricVehicle extends Vehicle
{
	public ElectricVehicle(String model, double maxSpeed)
	{
		this.model=model;
		this.maxSpeed=maxSpeed;
	}
	void charge(double time)
	{
		System.out.println("Vehicle details : ");
		System.out.println("Vehicle model : "+model);
		System.out.println("Vehicle Maximum Speed : "+maxSpeed);
		System.out.println("Time until battery is fully charged : "+time);
	}
}

// Define a main class
public class VehicleManagement
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Input details from the user
		System.out.println("Enter model and maximum speed of the vehicle : ");
		String model=sc.nextLine();
		double speed = sc.nextDouble();
		System.out.println("Enter if the vehicle has a charging time else 0 : ");
		double time=sc.nextDouble();
		System.out.println("Enter if the vehicle has volume for a fuel tank else 0 : ");
		double volume=sc.nextDouble();
		if(time==0.0)
		{
			PetrolVehicle petrolVehicle = new PetrolVehicle(model,speed,volume);
			petrolVehicle.refuel();
		}
		if(volume==0.0)
		{
			ElectricVehicle electricVehicle = new ElectricVehicle(model,speed);
			electricVehicle.charge(time);
		} 
	}
}