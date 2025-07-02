// Importing scanner class from util package
import java.util.Scanner;

// Define a class to store details of an order
class Order
{
	int orderId;
	String orderDate;
}

// Define a class to track the order
class ShippedOrder extends Order // Single Inheritance
{
	int trackingId;
}

// Define a class to show delivery details
class DeliveredOrder extends ShippedOrder // Multilevel Inheritance
{
	String deliveryDate
	public DeliveredOrder(int orderId,String orderDate,int trackingId,String deliveryDate)
	{
		this.orderId=orderId;
		this.orderDate=orderDate;
		this.trackingId=trackingId;
		this.deliveryDate=deliveryDate;
	}
	// Method to display details of the order
	void displayInfo()
	{
		System.out.println("Order Details : ");
		System.out.println("Order Id : "+orderId);
		System.out.println("Ordering Date : "+orderDate);
		System.out.println("Tracking Id of the order : "+trackingId);
		System.out.println("Delivery Date of the order : "+deliveryDate);
	}
}

// Defining main class
public class OnlineRetailOrderManagement
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Input values from the user
		System.out.println("Enter order id, ordered date, tracking id and delivery date of the order : ");
		int orderId=sc.nextInt();
		String orderDate=sc.nextLine();
		int trackId=sc.nextInt();
		String deliveryDate=sc.nextLine();
		// Object creating and method calling
		DeliveredOrder deliveredOrder = new DeliveredOrder(orderId,orderDate,trackId,deliveryDate);
		deliveredOrder.displayInfo();
	}
}