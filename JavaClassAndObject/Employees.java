// Class Definition of Employees
public class Employees
{
	// Initializing variables to store details of employees
	private String name;
	private int id;
	private int salary;
	// Defining Constructor to get details
	public Employees(String name, int id, int salary)
	{
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	public void displayDetails()
	{
		System.out.println("Employees Details : ");
		System.out.println("Name of the employee : "+this.name);
		System.out.println("Id of the employee : "+this.id);
		System.out.println("Salary of the employee : "+this.salary);
	}
}