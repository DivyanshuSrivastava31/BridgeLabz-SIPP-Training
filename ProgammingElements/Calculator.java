//importing Scanner class for user input
import java.util.Scanner;
//Class to compute a calculator
public class Calculator {
    public static void main(String[] args) {
        //Scanner class object
	Scanner sc = new Scanner(System.in);
        //user input for first number
	double number1 = sc.nextDouble();
	//user input for second number
        double number2 = sc.nextDouble();
	//calculate sum for both the numbers
        double sum = number1 + number2;
	//calculate difference of both the numbers
        double difference = number1 - number2;
	//calculate product of both the numbers
        double product = number1 * number2;
	//calculate division of both the numbers
        double division = number1 / number2;
	//Printing sum of both numbers
        System.out.println("Addition: " + sum);
	//Printing difference of both the numbers
        System.out.println("Subtraction: " + difference);
	//Printing product of both the numbers
        System.out.println("Multiplication: " + product);
	//Printing division of both the numbers
        System.out.println("Division: " + division);
    }
}
