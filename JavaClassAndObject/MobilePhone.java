// Defining class to handle mobile phone details
public class MobilePhone
{
	// Initializing variables to store details of mobile phone
	private String brand;
	private String model;
	private double price;
	// Defining a constructor to store details of mobile phone
	public MobilePhone(String brand, String model, double price)
	{
		this.brand=brand;
		this.model=model;
		this.price=price;
	}
	// Method to display mobile phone details
	public void displayDetails()
	{
		System.out.println("Mobile phone Details : ");
		System.out.println("Brand of the mobile phone : "+this.brand);
		System.out.println("Model of the mobile phone : "+this.model);
		System.out.println("Price of the mobile phone : "+this.price);
	}
}