//Importing Scanner Class from util package
import java.util.Scanner;
//Computing the sum until the user enters zero or negative number
public class SumOfNumbersUsingForIntegerValues
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Initializing a variable to store the sum of the numbers
		int sum=0;
		//initializing a loop to start taking inputs
		while(true)
		{
			System.out.println("Enter a number : ");
			int number=sc.nextInt();
			//Check whether the number is zero or negative or positive
			if(number<=0)
			{
				break;
			}
			else
			{
				sum+=number;
			}
		}
		//Printing the result
		System.out.println("Sum of the numbers input by the user is "+sum);
		//Closing the scanner class
		sc.close();
	}
}