//Importing Scanner CLass from util package
import java.util.Scanner;
//Computing operation on three Double type numbers
public class DoubleOpt {
    public static void main(String[] args) {
	//Creating object of Scanner class
        Scanner sc = new Scanner(System.in);
	//Taking Double type input from user
        double a = sc.nextDouble();
	//Taking Double type input from user
        double b = sc.nextDouble();
	//Taking Double type input from user
        double c = sc.nextDouble();
	//Performing all the four operations on Double type Numbers as mentioned
        double res1 = a + b * c;
        double res2 = a * b + c;
        double res3 = c + a / b;
        double res4 = a % b + c;
	//Printing results of all the calculations on Double type numbers
        System.out.println("Results: " + res1 + ", " + res2 + ", " + res3 + ", " + res4);
    }
}
