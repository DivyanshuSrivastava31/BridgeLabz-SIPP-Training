// Define a class to simulate vehicle registration system
public class VehicleRegistration
{
	// static variable to store registration fee
	static int fee=5000;
	// initialize variable to store data
	private String name;
	private String type;
	// Final variable to store registration number
	final long regNumber;
	// Define a constructor
	public VehicleRegistration(String name, String type, long regNumber)
	{
		this.name=name;
		this.type=type;
		this.regNumber=regNumber;
	}
	// Method to display details
	void displayDetails()
	{
		if(this instanceof VehicleRegistration)
		{
			System.out.println("Vehicle Owner details : ");
			System.out.println("Name of the owner : "+name);
			System.out.println("Type of the vehicle : "+type);
			System.out.println("Registration Number of the vehicle : "+regNumber);
		}
		else
			System.out.println("Invalid object created");
	}
	// Method to update registration fee
	void updateRegistrationFee(int fee)
	{
		if(this instanceof VehicleRegistration)
		{
			this.fee=fee;
		}
		else
			System.out.println("Invalid object created");
	}
	
	// Main method
	public static void main(String... args)
	{
		VehicleRegistration vehicleRegistration1 = new VehicleRegistration("Amritanshu Gupta","Buggaati",2215000220);
		VehicleRegistration vehicleRegistration2 = new VehicleRegistration("Parth Agarwal","Mercede-Benz",2215001234);
		vehicleRegistration1.displayDetails();
		vehicleRegistration2.updateRegistrationFee("6500");
		vehicleRegistration2.displayDetails();
	}
}