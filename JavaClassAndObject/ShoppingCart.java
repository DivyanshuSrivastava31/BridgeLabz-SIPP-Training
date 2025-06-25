// Define a class to simulate a shopping cart
public class ShoppingCart
{
	// Initialize a variable to store cart details
	private String[] cartItem=new String[100];
	private int[] price=new int[100];
	private int[] quantity=new int[100];
	private int bill=0;
	// Define a constructor to add an item to the cart
	public ShoppingCart(String item, int price, int quantity, int itemNumber)
	{
		cartItem[itemNumber]=item;
		price[itemNumber]=price;
		quantity[itemNumber]=quantity;
	}
	// Method to remove an item to the cart
	public void removeItem(String item)
	{
		if(cartItem[0]==null)
			System.out.println("Your cart is empty");
		else
		{
			for(int loop=0; loop<cartItem.length; loop++)
			{
				if(cartItem[loop].equalsIgnoreCase(item))
				{
					for(int loop2=loop; loop2<cartItem.length; loop2++)
					{
						cartItem[loop2]=cartItem[loop2+1];
						price[loop2]=price[loop2+1];
						quantity[loop2]=quantity[loop2+1];
					}
					cartItem[cartItem.length]=null;
					price[cartItem.length]=0;
					quantity[cartItem.length]=0;
					break;
				}
			}
		}
	}
	// Method to calculate total cost
	public void totalCost()
	{
		for(int loop=0; loop<price.length; loop++)
		{
			bill+=price[loop]*quantity[loop];
		}
	}
	// Method to display cart bill
	public void displayDetails()
	{
		System.out.println("Cart Items : ");
		for(int loop=0; loop<cartItem.length; loop++)
		{
			System.out.print(cartItem[loop]+" ");
			System.out.print(quantity[loop]+" ");
			System.out.println(quantity[loop]*price[loop]);
		}
		System.out.println("Total bill : "+bill);
	}
}