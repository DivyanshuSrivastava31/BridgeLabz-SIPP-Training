//Importing Scanner class from util package
import java.util.Scanner;
//Compute BMI of a number of persons and determine their status
public class BMIofAPerson
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Take number of persons from the user
		int numberofpersons=sc.nextInt();
		//Declaring 1-D Arrays for height, weight, BMI and status of person
		double[] height=new double[numberofpersons];
		double[] weight=new double[numberofpersons];
		double[] bmi=new double[numberofpersons];
		String[] status=new String[numberofpersons];
		//Taking height and weight inputs from the user
		//Computing BMI based on the formula :BMI = weight / (height * height)
		for(int loop=0;loop<numberofpersons;loop++)
		{
			height[loop]=sc.nextDouble();
			weight[loop]=sc.nextDouble();
			bmi[loop]=weight[loop]/(height[loop]*height[loop]);
			if(bmi[loop]<=18.4)
			{
				status[loop]="Person is Underweight";
			}
			else if(bmi[loop]>=18.5&&bmi[loop]<=24.9)
			{
				status[loop]="Person is Normal";
			}
			else if(bmi>=25.0&&bmi<=39.9)
			{
				status[loop]="Person is Overweight";
			}
			else
			{
				status[loop]="Person is Obese";
			}

		}
		//Printing the result
		for(int loop=0;loop<numberofpersons;loop++)
		{
			System.out.println("Weight of the person : "+weight[loop]);
			System.out.println("Height of the person : "+height[loop]);
			System.out.println("BMI of the person : "+bmi[loop]);
			System.out.println("Status of the person : "+status[loop]);
		}
		//Closing scanner class
		sc.close();
	}
}