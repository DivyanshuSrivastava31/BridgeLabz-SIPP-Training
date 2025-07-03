// Interface for discount-related operations
interface Discountable 
{
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// Abstract class for food items
abstract class FoodItem 
{
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity)
    {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters - Encapsulation
    public String getItemName()
    { 
	return itemName; 
    }
    public double getPrice()
    { 
	return price;
    }
    public int getQuantity()
    { 
	return quantity; 
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateTotalPrice();

    // Concrete method
    public String getItemDetails()
    {
        return "Item: " + itemName + ", Price: ₹" + price + ", Quantity: " + quantity;
    }
}

// Veg item implementation
class VegItem extends FoodItem implements Discountable 
{
    private double discountApplied = 0;

    public VegItem(String itemName, double price, int quantity)
    {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice()
    {
        return getPrice() * getQuantity();
    }

    public void applyDiscount(double percentage)
    {
        discountApplied = (calculateTotalPrice() * percentage) / 100;
    }

    public String getDiscountDetails()
    {
        return "Veg Discount: ₹" + discountApplied;
    }
}

// Non-Veg item implementation
class NonVegItem extends FoodItem implements Discountable 
{
    private double discountApplied = 0;
    private final double nonVegCharge = 30.0; // Extra charge per item

    public NonVegItem(String itemName, double price, int quantity)
    {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice()
    {
        return (getPrice() + nonVegCharge) * getQuantity();
    }

    public void applyDiscount(double percentage)
    {
        discountApplied = (calculateTotalPrice() * percentage) / 100;
    }

    public String getDiscountDetails()
    {
        return "Non-Veg Discount: ₹" + discountApplied;
    }
}

// Main class to test the system
public class FoodDeliverySystem 
{
    // Polymorphic method to process orders
    public static void processOrder(FoodItem item)
    {
        System.out.println(item.getItemDetails());
        System.out.println("Total Price: ₹" + item.calculateTotalPrice());

        if (item instanceof Discountable) 
	{
            Discountable d = (Discountable) item;
            d.applyDiscount(10); // applying 10% discount
            System.out.println(d.getDiscountDetails());
        }

    }

    public static void main(String... args)
    {
        FoodItem veg = new VegItem("Paneer Butter Masala", 200, 2);
        FoodItem nonVeg = new NonVegItem("Chicken Biryani", 250, 2);

        processOrder(veg);
        processOrder(nonVeg);
    }
}
