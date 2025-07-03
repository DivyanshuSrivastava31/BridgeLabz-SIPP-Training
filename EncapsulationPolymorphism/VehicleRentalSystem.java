// Interface to define insurance behaviours
interface Insurable
{
	void calculateInsurance();
	void getInsuranceDetails();
}
// Abstract class : Vehicle
abstract class Vehicle
{
	private String vehicleNumber;
	private int vehicleRate;
	private String vehicleType;
	private int days;
	public Vehicle(String vehicleNumber, int vehicleRate, String vehicleType,int days)
	{
		this.vehicleNumber=vehicleNumber;
		this.vehicleRate=vehicleRate;
		this.vehicleType=vehicleType;
		this.days=days;
	}
	// Getter and setter methods
	public String getVehicleNumber()
	{
		return this.vehicleNumber;
	}
	public int getVehicleRate()
	{
		return this.vehicleRate;
	}
	public String getVehicleType()
	{
		return this.vehicleType;
	}
	public int getDays()
	{
		return this.days;
	}
	abstract int calculateRentalCost(int days);
	void displayDetails()
	{
		System.out.println("Vehicle Details : ");
		System.out.println("Vehicle Number : "+vehicleNumber);
		System.out.println("Vehicle Rate : "+vehicleRate);
		System.out.println("Vehicle Type : "+vehicleType);
		System.out.println("Number of Days to rent the vehicle : "+days);
		System.out.println("Rental Cost : "+calculateRentalCost(days));
	}
}

// Sub class : Car , Bike , Truck
class Car extends Vehicle
{
	public Car(String vehicleNumber,int vehicleRate,String vehicleType,int days)
	{
		super(vehicleNumber,vehicleRate,vehicleType,days);
	}
	int calculateRentalCost(int days)
	{
		return days*getVehicleRate();
	}
}

class Bike extends Vehicle
{
	public Bike(String vehicleNumber,int vehicleRate,String vehicleType,int days)
	{
		super(vehicleNumber,vehicleRate,vehicleType,days);
	}
	int calculateRentalCost(int days)
	{
		return days*getVehicleRate();
	}
}

class Truck extends Vehicle
{
	public Truck(String vehicleNumber,int vehicleRate,String vehicleType,int days)
	{
		super(vehicleNumber,vehicleRate,vehicleType,days);
	}
	int calculateRentalCost(int days)
	{
		return days*getVehicleRate();
	}
}

// Main class
public class VehicleRentalSystem
{
	public static void main(String... args)
	{
		Vehicle[] vehicle = new Vehicle[3];
		vehicle[0]=new Car("UP80 CL 7883",1000,"Sedan",7);
		vehicle[1]=new Bike("UP80 CL 7883",400,"Beach Bike",7);
		vehicle[2]=new Truck("UP80 CL 7883",2000,"Mini Truck",7);
		
		for(Vehicle vehi : vehicle)
		{
			vehi.displyDetails();
		}
	}
}