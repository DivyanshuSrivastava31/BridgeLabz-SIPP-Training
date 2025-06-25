// Class Definition to track Item details
public class Item
{
	// Initializing variable to store item details
	private int itemCode;
	private String itemName;
	private double itemPrice;
	// Defining a constructor to store item details
	public Item(int itemCode, String itemName, String itemPrice)
	{
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	// Method to display details of the item
	public void displayDetails()
	{
		System.out.println("Item Details : ");
		System.out.println("Code of the item : "+this.itemCode);
		System.out.println("Name of the item : "+this.itemName);
		System.out.println("Price of the item : "+this.itemPrice);
	}
	// Method to calculate total cost for the given quantity
	public void totalCost(int quantity)
	{
		System.out.println("Total Cose for "+quantity+" items is "+(quantity*this.itemPrice));
	}
}