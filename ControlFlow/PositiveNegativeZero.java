//Importing Scanner Class from util package
import java.util.Scanner;
//Check whether a number is positive, negative or zero
public class PositiveNegativeZero
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking Integer input from number
		int number=sc.nextInt();
		//Check if the number is above or below zero or is equal to zero
		if(number>0)
		{
			System.out.println("Its a positive number");
		}
		else if(number==0)
		{
			System.out.println("The number is Zero");
		}
		else
		{
			System.out.println("Its a negative number");
		}
		//Closing Scanner class
		sc.close();
	}
}