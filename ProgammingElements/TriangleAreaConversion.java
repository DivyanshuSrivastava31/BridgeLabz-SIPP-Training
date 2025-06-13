//importing Scanner class for user input
import java.util.Scanner;
//Computer Triangle Area And convert it into square inches
public class TriangleAreaConversion {
    public static void main(String[] args) {
	//Object of Scanner class
        Scanner sc = new Scanner(System.in);
	//Base Input value from user in cm
        double base = sc.nextDouble();
	//Height input value from user in cm
        double height = sc.nextDouble();
	//Calculate are of triangle in cm square
        double area_cm = 0.5 * base * height;
	//Converting cm square into inch square
        double area_inch = area_cm / (2.54 * 2.54);
	//Printing triangle area in Square inches
        System.out.println("Area in square inches: " + area_inch);
	//Printing triangle area in Sqaure cm
        System.out.println("Area in square cm: " + area_cm);
    }
}
