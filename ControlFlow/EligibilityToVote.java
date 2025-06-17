//Importing Scanner Class from util package
import java.util.Scanner;
//Check whether a person is eligible to vote or not
public class EligibilityToVote
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Take a person's age as an input from user
		int age=sc.nextInt();
		//Check if the person's age is above 18 or not
		if(age>=18)
		{
			Sysem.out.println("The person can vote");
		}
		else
		{
			System.out.println("The person cannot vote");
		}
		//Closing scanner class
		sc.close();
	}
}