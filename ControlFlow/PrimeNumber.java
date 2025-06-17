//Importing Scanner Class from util package
import java.util.Scanner;
//Check whether a Number is Prime Number or not
//Prime Number :A number that can be divided exactly only by itself and 1
public class PrimeNumber
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking integer input from the user
		int number=sc.nextInt();
		//Initialize a variable to store the result
		boolean result=true;
		//Check if the number is greater than one
		if(number<1)
		{
			result=false;
		}
		else
		{
			//Initializing a loop to check if the number is prime
			for(int count=2;count<=number/2+1;count++)
			{
				if(number%count==0)
				{
					result=false;
					break;
				}
			}
		}
		//Printing the result
		System.out.println(result);
		//Closing scanner class
		sc.close();
	}
}