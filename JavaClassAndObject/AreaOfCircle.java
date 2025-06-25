// Class Definition to calculate area of a circle
public class AreaOfCircle
{
	// Initialize variables to store radius and area of the circle
	private double radius;
	private double area;
	// Defining a constructor to store radius of the circle
	public AreaOfCircle(double radius)
	{
		this.radius=radius;
	}
	// Method to calculate area of the circle
	public void calculateArea()
	{
		this.area=(22/7)*this.radius*this.radius;
	}
	// Method to display area of the circle
	public void displayArea()
	{
		System.out.println("Area of circle for the radius "+this.radius+" is "+this.area);
	}
}