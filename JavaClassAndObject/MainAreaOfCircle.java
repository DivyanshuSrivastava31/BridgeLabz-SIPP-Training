// Importing scanner class from util package
import java.util.Scanner
// Main class to define the object of AreaOfCircle class
public class MainAreaOfCircle
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking radius of the circle from the user
		double radius=sc.nextDouble();
		// Creating object and calling method to calculate and display area of the circle 
		AreaOfCircle objArea = new AreaOfCircle(radius);
		objArea.calculateArea();
		objArea.displayArea();
		// Closing object of scanner class
		sc.close();
	}
}