//Importing Scanner Class from util package
import java.util.Scanner;
//Computing FizzBuzz Concept using while loop
public class FizzBuzzUsingWhile
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking an integer type input from the user
		int number=sc.nextInt();
		//Initializing loop to compute FizzBuzz Concept
		int loop=1;
		while(loop<=number)
		{
			if(loop%3==0)
			{
				System.out.println("Fizz");
			}
			else if(loop%5==0)
			{
				System.out.println("Buzz");
			}
			else if(loop%3==0&&loop%5==0)
			{
				System.out.println("FizzBuzz");
			}
			loop++;
		}
		//Closing the scanner class
		sc.close();
	}
}