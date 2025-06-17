//Importing Scanner Class from util package
import java.util.Scanner;
//Listing the greatest Factor of a number using while
public class GreatestFactor
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking integer type input from user
		int number=sc.nextInt();
		//initializing a counter to calculate greatest factor
		int counter=number-1;
		//initializing the loop
		while(counter>1)
		{
			if(number%counter==0)
			{
				System.out.println("Greatest Factor of the number "+number+" is "+counter);
				break;
			}
			counter--;
		}
		//Closing the scanner class
		sc.close();
	}
}