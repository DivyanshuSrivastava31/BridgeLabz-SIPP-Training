// Importing scanner class from util package
import java.util.Scanner
// Main class to define the object of ShoppingCart class
public class MainShoppingCart
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		for(int loop=1; loop<=10; loop++)
		{
			// Choose whether to add or remove an item from the cart
			System.out.println("Add or remove an item from the cart : ");
			String choice=sc.nextLine();
			switch(choice)
			{
				case "Add" :
					// Take user input for item name, quantity and price
					String name=sc.nextLine();
					int quantity=sc.nextInt();
					int price=sc.nextInt();
					ShoppingCart objCart+"_"+loop=new ShoppingCart(name,price,quantity,loop)
					break;
				case "Remove" :
					// Take user input for item name
					ShoppingCart objCart=new ShoppingCart()
					objCart.removeItem(sc.nextLine());
					break;
			}
			ShoppingCart objBill = new ShoppingCart();
			pbjBill.totalCost();
			objBill.displayDetails;
		}
		// Closing object of scanner class
		sc.close();
	}
}