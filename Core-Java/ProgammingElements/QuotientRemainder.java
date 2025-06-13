Importing Scanner class from util package
import java.util.Scanner;
//Computing quotient and remainder of two numbers
public class QuotientRemainder {
    public static void main(String[] args) {
	//Object of Scanner class
        Scanner sc = new Scanner(System.in);
	//Taking first number from user
        int number1 = sc.nextInt();
	//Taking second number from user
        int number2 = sc.nextInt();
	//Calculating quotient of two numbers
        int quotient = number1 / number2;
	//Calculating remainder of two numbers
        int remainder = number1 % number2;
	//Printing Quotient of two numbers
        System.out.println("Quotient: " + quotient);
	//Printing Remainder of two numbers
        System.out.println("Remainder: " + remainder);
    }
}
