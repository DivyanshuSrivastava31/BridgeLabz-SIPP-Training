// Importing Scanner class from util package
import java.util.Scanner;
// Check collinearity of two triangles using slope method and formula
public class CollinearityCheck 
{
    // Check using slope method
    public static boolean areCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    // Check using area of triangle formula
    public static boolean areCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return area == 0;
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Input 3 points from the user
        int x1 = sc.nextInt(), y1 = sc.nextInt();

        int x2 = sc.nextInt(), y2 = sc.nextInt();

        int x3 = sc.nextInt(), y3 = sc.nextInt();

        boolean slopeCollinear = areCollinearSlope(x1, y1, x2, y2, x3, y3);
        boolean areaCollinear = areCollinearArea(x1, y1, x2, y2, x3, y3);
	// Displaying result
        System.out.println("Collinear (Slope Method)? " + slopeCollinear);
        System.out.println("Collinear (Area Method)? " + areaCollinear);
	// Closing scanner class
	sc.close();
    }
}
