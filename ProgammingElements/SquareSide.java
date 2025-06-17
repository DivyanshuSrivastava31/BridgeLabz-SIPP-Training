//Import Scanner class from util package
import java.util.Scanner;
//Computing square side from its perimeter
public class SquareSide {
    public static void main(String[] args) {
	//Creating object of Scanner Class
        Scanner sc = new Scanner(System.in);
	//Taking perimeter input from user
        double perimeter = sc.nextDouble();
	//Calculating side from Perimeter
        double side = perimeter / 4;
	//Printing Length of side of square
        System.out.println("Side length: " + side);
    }
}
