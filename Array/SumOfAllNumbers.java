//Importing Scanner class from util package
import java.util.Scanner;
//Compute Sum of all numbers in the array
public class SumOfAllNumbers
{
	public static void main(String... args)
	{
		//Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		//Declaring a 1-D Array with size of 10
		double[] numbers=new double[10];
		//Initializing a variable to store sum of elements
		double sum=0.0;
		//Initializing a counter to count the digits
		int counter=0;
		//Initializing an infinite loop to enter the elements
		while(true)
		{
			numbers[counter]=sc.nextInt();
			sum+=numbers[counter];
			counter=counter+1;
			if(numbers[counter-1]<=0||counter==10)
			{
				break;
			}
		}
		System.out.println("Sum of all the values : "+sum);
		//closing the scanner class
		sc.close();
	}
}