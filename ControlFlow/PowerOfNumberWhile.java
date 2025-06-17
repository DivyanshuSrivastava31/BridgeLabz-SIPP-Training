//Importing Scanner Class from util package
import java.util.Scanner;
//Computing the power of a number using while loop
public class PowerOfNumberWhile
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking number and power as an input from the user
		int number=sc.nextInt();
		int power=sc.nextInt();
		//Initialize a variable to store the result
		int result=1;
		//Calculating the power of the number
		int loop=1;
		while(loop<=power)
		{
			result*=number;
			loop++;
		}
		System.out.println("The number "+number+" to the power "+power+" is "+result);
		//Closing scanner class
		sc.close();
	}
}