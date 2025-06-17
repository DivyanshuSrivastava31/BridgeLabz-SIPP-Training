//Importing Scanner Class from util package
import java.util.Scanner;
//Check among three persons who is the tallest and who is the youngest
public class AgeHeight
{
	public static void main(String... args)
	{
		//Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		//Declaring 2 1-D Arrays to store age and height of Amar, Akbar, Anthony
		int[] age=new int[3];
		double[] height=new double[3];
		//Taking age and height inputs from user in the order
		//First-Amar, Second-Akbar, Third-Anthony
		for(int loop=0;loop<3;loop++)
		{
			age[loop]=sc.nextInt();
			height[loop]=sc.nextDouble();
		}
		//Sorting both the arrays using linear sort
		for(int outer_loop=0;outer_loop<3;outer_loop++)
		{
			for(int inner_loop=0;inner_loop<3;inner_loop++)
			{
				if(age[outer_loop]>age[inner_loop])
				{
					int swap_number=age[inner_loop];
					age[inner_loop]=age[outer_loop];
					age[outer_loop]=swap_number;
				}
				if(height[outer_loop]>height[inner_loop])
				{
					int swap_number=height[inner_loop];
					height[inner_loop]=height[outer_loop];
					height[outer_loop]=swap_number;
				}
			}
		}
		System.out.println("Youngest among the three is "+age[0]);
		System.out.println("Tallest among the three is "+height[2]);
		//Closing the scanner class
		sc.close();
	}
}