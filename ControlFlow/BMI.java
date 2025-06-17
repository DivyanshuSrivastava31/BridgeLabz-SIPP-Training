//Importing Scanner class from util package
import java.util.Scanner;
//Checking the BMI of a Person and determining his status
public class BMI
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc=new Scanner(System.in);
		//Taking user input for weight in kg and height in cm
		double height=sc.nextDouble();
		double weight=sc.nextDouble();
		//Converting height in cm to meter
		double height_meter=height*0.01;
		//Computing BMI using formula: BMI = weight / (height * height)
		double bmi=weight/(height*height);
		System.out.println("BMI of the person : "+bmi);
		//Determining status of the person w.r.t. BMI
		if(bmi<=18.4)
		{
			System.out.println("Person is Underweight");
		}
		else if(bmi>=18.5&&bmi<=24.9)
		{
			System.out.println("Person is Normal");
		}
		else if(bmi>=25.0&&bmi<=39.9)
		{
			System.out.println("Person is Overweight");
		}
		else
		{
			System.out.println("Person is Obese");
		}
		//Closing Scanner class
		sc.close();
	}
}