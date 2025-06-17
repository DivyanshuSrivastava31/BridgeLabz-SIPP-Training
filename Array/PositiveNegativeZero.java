//Importing Scanner class from util package
import java.util.Scanner;
//Check various comparison numbers on an array of numbers
//Like positive,negative,zero
public class PositiveNegativeZero
{
	public static void main(String... args)
	{
		//Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		//Declaring an array of size 5
		int[] numbers=new int[5];
		//Taking input elements from the user computing the result
		for(int loop=0;loop<5;loop++)
		{
			numbers[loop]=sc.nextInt();
			if(numbers[loop]==0)
			{
				System.out.println("The number "+numbers[loop]+" is zero");
			}
			else if(numbers[loop]<0)
			{
				System.out.println("The number "+numbers[loop]+" is negative");
			}
			else
			{
				System.out.println("The number "+numbers[loop]+" is positive");
				if(numbers[loop]%2==1)
				{
					System.out.println("The number "+numbers[loop]+" is odd number");
				else
				{
					System.out.println("The number "+numbers[loop]+" is even number");
				}
			}
		}
		if(numbers[0]>numbers[4])
		{
			System.out.println("The first element "+numbers[0]+" is greater than Last element "+numbers[4]);
		}
		else if(numbers[0]<numbers[4])
		{
			System.out.println("The first element "+numbers[0]+" is lesser than Last element "+numbers[4]);
		}
		else
		{
			System.out.println("Both the elements are equal to each other");
		}
		//Closing scanner class
		sc.close();
	}
}