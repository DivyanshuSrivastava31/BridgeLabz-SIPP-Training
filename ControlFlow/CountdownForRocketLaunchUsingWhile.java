//Importing Scanner Class from util package
import java.util.Scanner;
//Print countdown to the number from 1
public class CountdownForRocketLaunchUsingWhile
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking countdown input from user
		int countdown=sc.nextInt();
		//Starting the countdown for the rocket launch
		int i=1;
		while(i<=countdown)
		{
			System.out.println(i);
			i++;
		}
		//Closing the scanner class
		sc.close();
	}
}