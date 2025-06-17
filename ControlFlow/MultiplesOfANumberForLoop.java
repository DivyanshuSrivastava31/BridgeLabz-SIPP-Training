//Importing Scanner Class from util package
import java.util.Scanner;
//Listing all the Factors of a number
public class MultiplesOfANumberForLoop
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking integer type input from user
		int number=sc.nextInt();
		//Checking whether the number is below 100 and is positive
		if(number>0)
		{
			
			//initializing the loop
			for(int counter=number-1;counter>1;counter--)
			{
				if(number%counter==0)
				{
					System.out.println(counter);
				}
				
			}
		}
		else
		{
			System.out.println("The number is invalid");
		}
		//Closing the scanner class
		sc.close();
	}
}