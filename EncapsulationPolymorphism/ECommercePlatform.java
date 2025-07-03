// Interface for defining product behavior
interface Taxable
{
	double calculateTax();
	double getTaxDetails();
}
// Abstract class 
abstract class Product implements Taxable
{
	private int productId;
	private String name;
	private double price;
	private double tax;
	public abstract double calculateDiscount();
	public Product(int productId,String name,double price)
	{
		this.productId=productId;
		this.name=name;
		this.price=price;
	}
	// Getter and Setter methods
	public int getProductId()
	{
		return this.productId;
	}
	public String getName()
	{
		return this.name;
	}
	public double getPrice()
	{
		return this.price;
	}
	public double getTaxDetails()
	{
		return this.tax;
	}
	double calculateTax()
	{
		this.tax=0.12 * this.price;
	}
	public void displayDetails()
	{
		System.out.println("Product Details : ")
		System.out.println("Product Id : "+productId);
		System.out.println("Product Name : "+name);
		System.out.println("Product Base price : "+price);
		System.out.println("Tax on the product : "+tax);
		System.out.println("Discount on the product : "+calculateDiscount());
		System.out.println("Final Bill : "+(price+tax-calculateDiscount()));
	}
}
// Sub class : Electronics
class Electronics extends Product
{
	double discount;
	public Electronics(int productId,String name,double price,double discount)
	{
		super(productId,name,price);
		this.discount=discount;
	}
	double calculateDiscount()
	{
		return (this.discount/100)*getPrice();
	}
}
// Sub class : Groceries
class Groceries extends Product
{
	double discount;
	public Groceries(int productId,String name,double price,double discount)
	{
		super(productId,name,price);
		this.discount=discount;
	}
	double calculateDiscount()
	{
		return (this.discount/100)*getPrice();
	}
}
// Sub class : Clothing
class Clothing extends Product
{
	double discount;
	public Clothing(int productId,String name,double price,double discount)
	{
		super(productId,name,price);
		this.discount=discount;
	}
	double calculateDiscount()
	{
		return (this.discount/100)*getPrice();
	}
}


// Defining Main class
public class ECommercePlatform
{
	public static void main(String... args)
	{
		Product[] product = new Product[3];
		product[0]=new Electronics(80,"Godrej Double Door Refrigerator",15000.0,15.0);

		product[1]=new Groceries(213,"Spring onions",50.0,5.0);

		product[2]=new Clothing(4,"Denim T-Shirt",500.0,10.0);
	
		for(Product prod : product)
		{
			prod.displayDetails();
		}
	}
}