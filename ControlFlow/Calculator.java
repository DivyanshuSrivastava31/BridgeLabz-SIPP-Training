//Importing Scanner Class from util package
import java.util.Scanner;
//Create a Calculator for basic Mathematical Operations
public class Calculator
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking two Double type input from user
		double number1=sc.nextDouble();
		double number2=sc.nextDouble();
		//Taking operator input from user
		String operator=sc.nextLine();
		//Computing basic mathematical operations
		switch(operator)
		{
			case "+":
				System.out.println("Result is "+(number1+number2));
				break;
			case "-":
				System.out.println("Result is "+(number1-number2));
				break;
			case "*":
				System.out.println("Result is "+(number1*number2));
				break;
			case "/":
				System.out.println("Result is "+(number1/number2));
				break;
			default:
				System.out.println("Invalid Operator");
				break;
		}
		//Closing scanner class
		sc.close();
	}
}