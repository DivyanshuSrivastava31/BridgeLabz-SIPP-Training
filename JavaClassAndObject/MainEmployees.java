// Importing scanner class from util package
import java.util.Scanner
// Main class to define the object of Employees class
public class MainEmployees
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking name, id and salary from the user
		String name=sc.nextLine();
		int id=sc.nextInt();
		int salary=sc.nextInt();
		// Creating object and calling method to display details
		Employees objEmp = new Employees(name,id,salary);
		objEmp.displayDetails();
		// Closing object of scanner class
		sc.close();
	}
}