// Importing scanner class from util package
import java.util.Scanner
// Main class to define the object of Mobile Phone class
public class MainMobilePhone
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking brand, model and price from the user
		String model=sc.nextLine();
		String brand=sc.nextLine();
		double price=sc.nextDouble();
		// Creating object and calling method to display details
		MobilePhone objPhone = new MobilePhone(brand, model, price);
		objPhone.displayDetails();
		// Closing object of scanner class
		sc.close();
	}
}