//Importing Scanner class from util package
import java.util.Scanner;
//Computing Multiplication table of the number
public class MultiplicationTableFrom1to10
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Take an integer input from the user
		int number=sc.nextInt();
		//initialize an array to store the multiplication results
		int[] multiplication_results=new int[20];
		//initializing a loop to compute the result
		for(int loop=1;loop<=10;loop++)
		{
			multiplication_results[loop-1]=number*loop;
		}
		//Printing the result
		System.out.println("Multiplication table of the number "+number+" : ");
		for(loop=1;loop<=20;loop++)
		{
			System.out.println(number+" * "+loop+" = "+multiplication_results[loop-1]);
		}
		//Closing scanner class
		sc.close();
	}
}