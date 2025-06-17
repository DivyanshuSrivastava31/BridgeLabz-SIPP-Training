//Importing Scanner Class from util package
import java.util.Scanner;
//Compute bonus of employees of a company
public class BonusOfEmployees
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Take input salary from the user and year of service of the employee
		int salary=sc.nextInt();
		int yearofservice=sc.nextInt();
		//initialize a variable to store bonus of the employee
		double bonus=0;
		//check if the year of service is greater than 5 or not
		if(yearofservice>5)
		{
			//compute bonus
			bonus=0.05*salary;
		}
		System.out.println("Bonus of the employee : "+bonus);
		//Closing scanner class
		sc.close();
	}
}