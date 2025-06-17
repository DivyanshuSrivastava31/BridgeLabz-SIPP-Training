//Importing Scanner Class from util package
import java.util.Scanner;
//Check if a number is Harshad Number or not
//Harshad Number : an integer that is divisible by the sum of its digits
public class HarshadNumber
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Take an integer input from user
		int number=sc.nextInt();
		//initialize a variable to store sum of digits
		int sum=0;
		//initialize a loop to extract digits from number
		int loop=number;
		while(loop>0)
		{
			int digit=loop%10;
			sum+=digit;
			loop=loop/10;
		}
		//Check if number is divisible by sum of digits
		if(number%sum==0)
		{
			System.out.println("It is a Harshad Number");
		}
		else
		{
			System.out.println("It is not a Harshad Number");
		}
		//Closing scanner class
		sc.close();
	}
}