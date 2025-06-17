//Importing Scanner Class from util package
import java.util.Scanner;
//Compute multiplication table of a number
public class MultiplicationTable
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking integer input from the user
		int number=sc.nextInt();
		//Initialize a loop to compute multiplication table of the number
		for(int loop=1;loop<=20;loop++)
		{
			System.out.println(number+" * "+loop+" = "+(number*loop));
		}
		//Closing scanner class
		sc.close();
	}
}