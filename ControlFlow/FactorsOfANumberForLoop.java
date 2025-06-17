//Importing Scanner Class from util package
import java.util.Scanner;
//Listing all the Factors of a number using for loop
public class FactorsOfANumberForLoop
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking integer type input from user
		int number=sc.nextInt();	
		//initializing the loop
		for(int counter=number-1;counter>1;counter--)
		{
			if(number%counter==0)
			{
				System.out.println(counter);
			}
			
		}
		//Closing the scanner class
		sc.close();
	}
}