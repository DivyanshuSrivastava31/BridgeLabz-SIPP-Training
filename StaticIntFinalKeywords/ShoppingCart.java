// Define a class to simulate a shopping cart system
public class ShoppingCart
{
	// Static variable discount
	static int discount = 15;
	static double bill=0.0;
	// Initialize variables to store data
	private String productName;
	private int price;
	private int quantity;
	// Final variable to store product id
	final int productid;
	// Define a parameterized constructor
	public ShoppingCart(String productName, int price, int quantity, int productid)
	{
		this.productName=productName;
		this.price=price;
		this.quantity=quantity;
		this.productId=productid;
		bill+=(100-discount)/100*price*quantity;
	}
	// Method to update discount
	static void updateDiscount()
	{
		discount+=5;
	}
	// Method to calculate and display details
	public void displayDetails()
	{
		if(this instanceof ShoppingCart)
		{
			System.out.println("Cart details : ");
			System.out.println("Product Name : "+productName);
			System.out.println("Price : "+price);
			System.out.println("Quantity : "+quantity);
		}
		else
			System.out.println("Invalid object");
	}
	// Method to display bill
	public void displayBills()
	{
		System.out.println("Bill : "+bill);
	}
	// Main method
	public static void main(String... args)
	{
		ShoppingCart cart1=new ShoppingCart("Caramel Cookies",100,2,39);
		ShoppingCart cart2=new ShoppingCart("White Bread",80,1,46);
		// Display details and calculate bill
		cart1.displayDetails();
		cart1.updatDiscount();
		cart2.displayDetails();
		cart2.updatDiscount();
		cart2.displayBills();
	}
}