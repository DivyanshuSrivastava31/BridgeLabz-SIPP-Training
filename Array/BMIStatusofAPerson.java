//Importing Scanner class from util package
import java.util.Scanner;
//Compute BMI of a person and determine their health status
public class BMIStatusofAPerson
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking input of number of persons from the user
		int persons=sc.nextInt();
		//Declaring a 2-D Array to store data
		double[][] persondata = new double[persons][3];
		//Declaring a 1-D Array to store status of the person
		String[] weightstatus = new String[persons];
		//initialize a loop to take input weight and height from the user
		for(int loop1=0;loop1<persons;loop1++)
		{
			for(int loop2=0;loop2<2;loop2++)
			{
				persondata[loop1][loop2]=sc.nextDouble();
			}
			//Computing BMI based on the formula :BMI = weight / (height * height)
			persondata[loop1][2]=persondata[loop1][0]/(persondata[loop1][1]*persondata[loop1][1]);
		}
		//Printing the results
		for(int loop=0;loop1<persons;loop++)
		{
			System.out.println("Weight of the person : "+persondata[loop][0]);
			System.out.println("Height of the person : "+persondata[loop][1]);
			System.out.println("BMI of the person : "+persondata[loop][2]);
			if(persondata[loop][2]<=18.4)
			{
				System.out.println("Person is Underweight");
			}
			else if(persondata[loop][2]>=18.5&&persondata[loop][2]<=24.9)
			{
				System.out.println("Person is Normal");
			}
			else if(persondata[loop][2]>=25.0&&persondata[loop][2]<=39.9)
			{
				System.out.println("Person is Overweight");
			}
			else
			{
				System.out.println("Person is Obese");
			}
		}
		//Closing scanner class
		sc.close();
	}
}
