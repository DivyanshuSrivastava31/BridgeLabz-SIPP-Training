//Importing Scanner class from util package
import java.util.Scanner;
//To compute Reverse of a number
public class ReverseOfNumber
{
	public static void main(String... args)
	{
		//Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		//Taking an integer input from the user
		int number=sc.nextInt();
		//initialize a variable to count digits
		int count=0;
		//initialize a loop to count number of digits
		int loop=number;
		while(loop>0)
		{
			count++;
			loop=loop/10;
		}
		//Declaring a 1-D array
		int[] reversedigits=new int[count];
		//Computing the result and displaying it
		count=0;
		while(number>0)
		{
			reversedigits[count]=number%10;
			number=number/10;
			System.out.print(reversedigits[count]);
			count=count+1;
		}
		//Closing the scanner class
		sc.close();
	}
}
		