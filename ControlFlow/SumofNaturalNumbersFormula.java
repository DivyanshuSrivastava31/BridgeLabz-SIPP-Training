//Importing Scanner Class from util package
import java.util.Scanner;
//Comparing Sum of natural numbers with the formula n*(n+1)/2
public class SumofNaturalNumbersFormula
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking an input integer from user
		int number=sc.nextInt();
		//inititalizing variable for :
		//sum calculated using formula
		int sum_formula=0;
		//sum calculated using loop
		int sum_loop=0;
		//Check whether the number is Natural number or not
		if(number>0)
		{
			//Computing sum using the formulae : n*(n+1)/2
			sum_formula=number*(number+1)/2;
			//Computing sum using the while loop
			int i=1;
			while(i<=number)
			{
				sum_loop+=i;
				i++;
			}
			//Checking whether sum using formula and sum using loop are correct
			if(sum_loop==sum_formula)
			{
				System.out.println("Both are Correct");
			}
			else
			{
				System.out.println("Both are incorrect");
			}
		}
		else
		{
			System.out.println("The number "+number+" is not a natural number");
		}
		//Closing Scanner class
		sc.close();
	}
}