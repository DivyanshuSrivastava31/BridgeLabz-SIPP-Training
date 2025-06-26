// Define a class to display Patient details
public class Patient
{
	// static variable to store number of Patients
	static int totalPatients=0;
	static String hospital="City Hospital";
	// initialize variable to store data
	private String name;
	private int age;
	private String ailment;
	// Final variable to store roll number
	final int patientId;
	// Define a constructor
	public Patient(String name, int age, String ailment, int patientId)
	{
		this.name=name;
		this.age=age;
		this.ailment=ailment;
		this.patientId=patientId;
		totalPatients++;
	}
	// Method to display details
	void displayDetails()
	{
		if(this instanceof Patient)
		{
			System.out.println("Patient details : ");
			System.out.println("Name of the Patient : "+name);
			System.out.println("Age of the Patient : "+age);
			System.out.println("Patiend Id of the Patient : "+patientId);
			System.out.println("Ailment of the Patient : "+ailment);
		}
		else
			System.out.println("Invalid object created");
	}
	
	// Method to display total number of Patients
	void displayTotalPatients()
	{
		System.out.println("Total number of Patients in the university : "+totalPatients);
	}

	// Main method
	public static void main(String... args)
	{
		Patient Patient1 = new Patient("Amritanshu Gupta",20,"Arthritis",20);
		Patient Patient2 = new Patient("Parth Agarwal",31,"Cancer",34);
		Patient1.displayDetails();
		Patient2.displayDetails();
		Patient2.displayTotalPatients();
	}
}