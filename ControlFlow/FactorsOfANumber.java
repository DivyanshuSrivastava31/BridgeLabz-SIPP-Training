//Importing Scanner Class from util package
import java.util.Scanner;
//Listing all the Factors of a number
public class FactorsOfANumber
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking integer type input from user
		int number=sc.nextInt();
		//initializing a counter to calculate factors
		int counter=number-1;
		//initializing the loop
		while(counter>1)
		{
			if(number%counter==0)
			{
				System.out.println(counter);
			}
			counter--;
		}
		//Closing the scanner class
		sc.close();
	}
}