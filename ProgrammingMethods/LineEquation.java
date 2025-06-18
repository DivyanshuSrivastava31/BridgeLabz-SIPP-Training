// Importing array class from util package
import java.util.Scanner;
// Compute Euclidean distance from graph coordinates given by the user
public class LineEquation 
{

    // Calculate Euclidean distance
    public static double euclideanDistance(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Calculate slope (m) and y-intercept (b)
    public static double[] lineEquation(int x1, int y1, int x2, int y2)
    {
        double slope = (double)(y2 - y1) / (x2 - x1);
        double intercept = y1 - slope * x1;
        return new double[]{slope, intercept};
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input coordinates from the user
        int x1 = sc.nextInt(), y1 = sc.nextInt();
        int x2 = sc.nextInt(), y2 = sc.nextInt();
	// Displaying result
        double distance = euclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean distance = "+distance);

        if (x1 == x2) 
	{
            System.out.println("Vertical line – slope is undefined.");
        } 
	else 
	{
            double[] eq = lineEquation(x1, y1, x2, y2);
            System.out.println("Line equation: y = "+eq[0]+"x + "+eq[1]);
        }
	// Closing scanner class
	sc.close();
    }
}
