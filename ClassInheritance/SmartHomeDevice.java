// Importing scanner class from util package
import java.util.Scanner;
// Defining a class to store details of a device
class Device
{
	String deviceId;
	String status;
}

// Defining a class to store temperature details of the device
class Thermostat extends Device // Single inheritance
{
	String temperatureSettings;
	public Thermostat(String deviceId, String status, String temperatureSettings)
	{
		this.deviceId=deviceId;
		this.status=status;
		this.temperatureSettings=temperatureSettings;
	}
	void displayInfo()
	{
		System.out.println("Device Details : ");
		System.out.println("Device Id : "+deviceId);
		System.out.println("Status of the device : "+status);
		System.out.println("Temperature Settings of the device "+temperatureSettings);
	}
}

//  Defining Main class
public class SmartHomeDevice
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Input values from the user
		System.out.println("Enter device id, status and temperature settings of the device : ");
		String deviceId=sc.nextLine();
		String status=sc.nextLine();
		String temperatureSettings=sc.nextLine();
		// Object creating and method calling
		Thermostat thermostat=new Thermostat(deviceId, status, temperatureSettings);
		thermostat.displayInfo();
	}
}