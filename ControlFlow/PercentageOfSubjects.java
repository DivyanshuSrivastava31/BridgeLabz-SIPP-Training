//Importing Scanner Class from util package
import java.util.Scanner;
//Compute the percentage of three subjects marks and give remarks
public class PercentageOfSubjects
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Take marks of the three subjects as Input
		double physics=sc.nextDouble();
		double maths=sc.nextDouble();
		double chemistry=sc.nextDouble();
		//Computing percentage of the three subjects
		double percentage=(physics+maths+chemistry)/3;
		//Printing Percentage of students
		System.out.println("Percentage of the student : "+percentage);
		//Giving grade and remarks to students
		if(percentage>=80)
		{
			System.out.println("Grade of Student is A");
			System.out.println("Remark:Level 4, above agency normalized standards");
		}
		else if(percentage>=70&&percentage<=79)
		{
			System.out.println("Grade of Student is B");
			System.out.println("Remark:Level 3, at agency normalized standards");
		}
		else if(percentage>=60&&percentage<=69)
		{
			System.out.println("Grade of Student is C");
			System.out.println("Remark:Level 2 ,below ,but approaching agency normalized standards");
		}
		else if(percentage>=50&&percentage<=59)
		{
			System.out.println("Grade of Student is D");
			System.out.println("Remark:Level 1-,well below agency normalized standards");
		}
		else if(percentage>=40&&percentage<=49)
		{
			System.out.println("Grade of Student is E");
			System.out.println("Remark:Level 1-,too below agency normalized standards");
		}
		else
		{
			System.out.println("Grade of Student is R");
			System.out.println("Remark:Remedial Standards");
		}
		//Closing scanner class
		sc.close();
	}
}