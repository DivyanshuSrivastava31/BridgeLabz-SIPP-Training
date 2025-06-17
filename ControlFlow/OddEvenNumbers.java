//Importing Scanner Class from util package
import java.util.Scanner;
//Compute the odd and even numbers within a range
public class OddEvenNumbers
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking an integer input from the user
		int number = sc.nextInt();
		//Initializing a loop
		for(int loop=1;loop<=number;loop++)
		{
			if(loop%2==0)
			{
				System.out.println("The number "+loop+" is an Even Number");
			}
			else
			{
				System.out.println("The number "+loop+" is an Odd Number");
			}
		}
		//Closing scanner class
		sc.close();
	}
}