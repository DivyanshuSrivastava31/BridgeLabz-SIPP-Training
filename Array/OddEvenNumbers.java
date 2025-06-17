//Importing Scanner class from util package
import java.util.Scanner;
//Separating Odd and Even numbers within a given range
public class OddEvenNumbers
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking integer input from the user
		int number=sc.nextInt();
		//Declare two 1-d Arrays to store odd and even numbers
		int[] odd=new int[number/2+1];
		int[] even=new int[number/2+1];
		//initialize two separate counters to count even and odd numbers
		int count_even=0;
		int count_odd=0;
		//initializing a loop to sort out even and odd elements
		for(int loop=1;loop<=number;loop++)
		{
			//Check whether the number is even or odd
			if(loop%2==0)
			{
				even[count_even++]=loop;
			}
			else
			{
				odd[count_odd++]=loop;
			}
		}
		//Printing the results
		System.out.println("Odd Numbers:");
		for(int loop=0;loop<count_odd;loop++)
		{
			System.out.println(odd[loop]);
		}
		System.out.println("Even Numbers:");
		for(int loop=0;loop<count_even;loop++)
		{
			System.out.println(even[loop]);
		}
		//Closing scanner class
		sc.close();
	}
}