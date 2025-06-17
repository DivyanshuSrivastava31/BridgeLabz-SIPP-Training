//Importing Scanner Class from util package
import java.util.Scanner;
//Compute the factorial of an integer type value
public class FactorialOfANumberUsingWhile
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc=new Scanner(System.in);
		//Take integer type input from the user
		int number=sc.nextInt();
		//Initialize a variable to store factorial of the number
		int fact=1;
		//Check if the number is positive or not
		if(number>0)
		{
			//Compute the factorial of the number
			int i=1;
			while(i<=number)
			{
				fact*=i;
				i++;
			}
			//Printing the result
			System.out.println("Factorial of the number "+number+" is "+fact);
		}
		else
		{
			System.out.println("The number "+number+" is a negative number");
		}
		//Closing Scanner class
		sc.close();
	}
}