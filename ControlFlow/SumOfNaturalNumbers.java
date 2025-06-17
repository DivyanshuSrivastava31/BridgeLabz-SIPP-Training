//Importing Scanner class from util package
import java.util.Scanner;
//Check whether a number n is natural or not
//If yes, sum of n natural numbers
public class SumOfNaturalNumbers
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking an input number from the user
		int number=sc.nextInt();
		//Check whether the number is natural number or not
		if(number>0)
		{
			//Initializing a Variable to calculate sum
			int sum=0;
			//Creating a loop upto number to find the sum of natural numbers
			for(int i=1;i<=number;i++)
			{
				sum+=i;
			}
			System.out.println("The sum of "+number+" natural numbers is "+sum);
		}
		else
		{
			System.out.println("The number "+number+" is not a natural number");
		}
		//Closing the scanner
		sc.close();
	}
}
