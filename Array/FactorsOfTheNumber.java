//Importing Scanner class from util package
import java.util.Scanner;
//Finding all the factors of the number
public class FactorsOfTheNumber
{
	public static void main(String... args)
	{
		//Creating an object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking an integer input from the user
		int number=sc.nextInt();
		//Declaring a 1-D Array
		int[] factors = new int[number/2];
		//Initializing a counter to count the elements
		int counter=0;
		//Initializing a loop to find the factors of the number
		for(int loop=1;loop<=number/2;loop++)
		{
			if(number%loop==0)
			{
				factors[count++]=loop;
			}
		}
		System.out.println("Factors of the number "+number+" : ");
		for(int loop=0;loop<counter;loop++)
		{
			System.out.println(factors[count]);
		}
		//closing scanner class
		sc.close();
	}
}
		