//Importing Scanner Class from util package
import java.util.Scanner;
//Count the number of digits in a given number
public class CountingDigits
{
	public static void main(String... args)
	{
		//Creating object of Scanner Class
		Scanner sc = new Scanner(System.in);
		//Take integer input from user
		int number=sc.nextInt();
		//initialize a variable to count digits
		int count=0;
		//initialize a loop to extract digits
		while(number>0)
		{
			count++;
			number=number/10;
		}
		//Printing the result
		System.out.println("Number of digits in the number is "+count);
	}
} 