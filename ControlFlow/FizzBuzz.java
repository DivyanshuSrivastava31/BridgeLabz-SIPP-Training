//Importing Scanner Class from util package
import java.util.Scanner;
//Computing FizzBuzz Concept 
public class FizzBuzz
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking an integer type input from the user
		int number=sc.nextInt();
		//Initializing loop to compute FizzBuzz Concept
		for(int i=1;i<=number;i++)
		{
			if(i%3==0)
			{
				System.out.println("Fizz");
			}
			else if(i%5==0)
			{
				System.out.println("Buzz");
			}
			else if(i%3==0&&i%5==0)
			{
				System.out.println("FizzBuzz");
			}
		}
		//Closing the scanner class
		sc.close();
	}
}