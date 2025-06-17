//Importing Scanner Class from util package
import java.util.Scanner;
//Check whether a number is abundant number or not
//Abundant Number: An integer in which the sum of all the divisors of the number is greater than the number itself
public class AbundantNumber
{
	public static void main(String... args)
	{
		//Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		//Take an integer input from the user
		int number=sc.nextInt();
		//initializing a variable to store sum of factors
		int sum=0;
		//Initialize a loop to find factors
		for(int loop=1;loop<=number/2+1;loop++)
		{
			if(number%loop==0)
				sum+=loop;
		}
		if(sum>number)
		{
			System.out.println("It is an Abundant Number");
		{
		else
		{
			System.out.println("It is not an Abundant Number");
		}
		//Closing the Scanner class
		sc.close();
	}
}