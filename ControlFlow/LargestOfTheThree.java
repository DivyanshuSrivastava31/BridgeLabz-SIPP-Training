// Importing Scanner class from util package
import java.util.Scanner;
//Check among the three numbers which number is the largest
public class LargestOfTheThree
{
	public static void main(String... args)
	{
		//Creating Scanner class object
		Scanner sc = new Scanner(System.in);
		//Taking three Integer inputs from the user
		int number1=sc.nextInt();
		int number2=sc.nextInt();
		int number3=sc.nextInt();
		//Assigning variables to among the three which is the largest
		boolean is_first=false;
		boolean is_second=false;
		boolean is_third=false;
		//Checking which number among the three is the largest
		if(number1>number2)
		{
			if(number1>number3)
			{
				is_first=true;
			}
			else
			{
				is_third=true;
			}
		}
		else if(number2>number3)
		{
			is_second=true;
		}
		else
		{
			is_third=true;
		}
		//Printing the largest number among the three
		System.out.println("Is the first number the largest? "+is_first);
		System.out.println("Is the second number the largest? "+is_second);
		System.out.println("Is the third number the largest? "+is_third);
		//Close the scanner
		sc.close();
	}
}