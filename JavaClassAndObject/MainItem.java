// Importing scanner class from util package
import java.util.Scanner
// Main class to define the object of Item class
public class MainItem
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking item code, item name and item price from the user
		String itemName=sc.nextLine();
		int itemCode=sc.nextInt();
		int itemPrice=sc.nextInt();
		// Creating object and calling method to display details
		Item objItem = new Item(itemName, itemCode, itemPrice);
		objEmp.displayDetails();
		// Taking quantity from the user
		int quantity=sc.nextInt();
		objItem.totalCost(quantity);
		// Closing object of scanner class
		sc.close();
	}
}