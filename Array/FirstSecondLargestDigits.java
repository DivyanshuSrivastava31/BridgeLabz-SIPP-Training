//Importing Scanner class from util package
import java.util.Scanner;
//Compute a program to store first and second largest elements in the array
public class FirstSecondLargestDigits
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
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
		int[] array_of_digits=new int[count];
		//Initializing a loop to extract digits
		count=0;
		while(number>0)
		{
			array_of_digits[count]=number%10;
			number=number/10;
			count=count+1;
		}
		//Sorting the array using linear sort
		for(int outer_loop=0;outer_loop<count;outer_loop++)
		{
			for(int inner_loop=0;inner_loop<count;inner_loop++)
			{
				if(array_of_digits[outer_loop]>array_of_digits[inner_loop])
				{
					int swap_number=array_of_digits[inner_loop];
					array_of_digits[inner_loop]=array_of_digits[outer_loop];
					array_of_digits[outer_loop]=swap_number;
				}
			}
		}
		System.out.println("First Largest Digits within the number : "+array_of_digits[count-1]);
		System.out.println("Second Largest Digits within the number : "+array_of_digits[count-2]);
		//Closing the scanner class
		sc.close();
	}
}