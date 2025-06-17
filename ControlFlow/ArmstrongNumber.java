//Importing Scanner Class from util package
import java.util.Scanner;
//Check whether a number is Armstrong number or not
//Armstrong number: a number whose Sum of cubes of each digit results in the original number 
public class ArmstrongNumber
{
	public static void main(String... argss)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Take an integer input from the user
		int number=sc.nextInt();
		//initializing a variable to store the sum of squares
		int sum=0;
		//initialize a loop 
		int loop=number;
		while(loop>0)
		{
			//Extract last digit of the number
			int digit=loop%10;
			int sum+=digit**2;
			int loop=loop/10;
		}
		//check if the number and the sum are equal or not
		if(number==sum)
		{
			System.out.println("The number is an Armstrong Number");
		}
		else
		{
			System.out.println("The number is not an Armstrong Number");
		}
		//Close scanner class
		sc.close();
	}
}
			