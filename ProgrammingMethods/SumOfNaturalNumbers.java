//Importing Scanner class from util package
import java.util.*;
//Compute sum of natural numbers
public class SumOfNaturalNumbers
{
	//Method to calculate sum of n natural numbers
	void sumOfNaturalNumbers(int number)
	{
		//Declare a variable to calculate sum
		int sum=0;
		for(int loop=1;loop<=number;loop++)
		{
			sum+=loop;
		}
		//Display the result
		System.out.println("Sum of "+number+" natural numbers : "+sum);
	}
	public static void main(String... args)
	{
		//Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		//Taking integer input from the user
		int number=sc.nextInt();
		//Calling the object of the class to invoke the method
		new SumOfNaturalNumbers().sumOfNaturalNumbers(number);
		//Closing scanner class
		sc.close();
	}
}