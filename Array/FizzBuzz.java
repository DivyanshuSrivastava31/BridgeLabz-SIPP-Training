//Importing Scanner class from util package
import java.util.Scanner;
//Computing FizzBuzz Concept
public class FizzBuzz
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking integer input from the user
		int number=sc.nextInt();
		String[] fizzbuzz=new String[number+1];
		//Initializing the loop
		for(int loop=0;loop<=number;loop++)
		{
			if(loop%3==0)
			{
				fizzbuzz[loop]="Fizz";
			}
			else if(loop%5==0)
			{
				fizzbuzz[loop]="Buzz";
			}
			if(loop%3==0&&loop%5==0)
			{
				fizzbuzz[loop]="FizzBuzz";
			}
			else
			{
				fizzbuzz=Integer.toString(loop);
			}
		}
		//Printing the result
		for(int loop=0;loop<=number;loop++)
		{
			System.out.println(fizzbuzz[loop]);
		}
		//Closing scanner class
		sc.close();
	}
}