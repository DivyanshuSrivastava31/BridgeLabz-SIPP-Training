// Importing Scanner class from util package
import java.util.Scanner;
// Compute quadratic roots of numbers inputted by the user
public class QuadraticRoots 
{

    // Method to calculate roots of quadratic equation
    public static double[] findQuadraticRoots(double a, double b, double c) 
    {
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta > 0) 
	{
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } 
	else if (delta == 0) 
	{
            double root = -b / (2 * a);
            return new double[]{root};
        } 
	else 
	{
            // No real roots
            return new double[0];
        }
    }

    public static void main(String... args) 
    {
	//Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input a, b, c three numbers from the user

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        // Calculate and display roots
        double[] roots = findQuadraticRoots(a, b, c);
        if (roots.length == 2) 
	{
            System.out.println("Roots are: "+roots[0]+" and "+roots[1]);
        } 
	else if (roots.length == 1) 
	{
            System.out.println("One root: "+ roots[0]);
        } 
	else 
	{
            System.out.println("No real roots exist.");
        }
	// Closing scanner class
	sc.close();

    }
}
