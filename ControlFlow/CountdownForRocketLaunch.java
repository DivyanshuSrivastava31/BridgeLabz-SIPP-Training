//Importing Scanner Class from util package
import java.util.Scanner;
//Print countdown to the number from 1
public class CountdownForRocketLaunch
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking countdown input from user
		int countdown=sc.nextInt();
		//Starting the countdown for the rocket launch
		for(int i=1;i<=countdown;i++)
		{
			System.out.println(i)
		}
		//Closing the scanner class
		sc.close();
	}
}