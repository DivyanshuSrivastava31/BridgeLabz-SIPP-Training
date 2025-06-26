// Define a class to simulate employee management system
public class Employee
{
	// Static variable to store company's name
	static String companyName="IBM";
	// Static variable to count number of employees
	static int countEmployees=0;
	// Initialize Variables to store data
	private String name;
	private String designation;
	// Final variable to store id
	private final int empId;
	// Define constructor to retrieve data
	public Employee(String name, String designation, int empId)
	{
		this.name=name;
		this.designation=desgination;	
		this.empId=empId;
		countEmployees++;
	}
	// Method to display total number of employees
	int totalEmployees()
	{
		return countEmployees;
	}
	// Method to display employee details
	void displayDetails()
	{
		System.out.println("Employee Details : ");
		System.out.println("Company's Name : "+companyName);
		System.out.println("Name of the employee : "+name);
		System.out.println("Designation of the employee : "+designation);
		System.out.println("Id of employee : "+empId);
	}
	// Main method
	public static void main(String... args)
	{
		Employee emp1=new Employee("Amritanshu Gupta","Senior Developer","41");
		Employee emp2=new Employee("Aaditya Sharma","Junior Developer","45");
		// Display employee details
		emp1.displayDetails();
		emp2.displayDetails();
		// Display total number of employees
		System.out.println("Total number of employees : "+emp2.totalEmployees());
	}
}