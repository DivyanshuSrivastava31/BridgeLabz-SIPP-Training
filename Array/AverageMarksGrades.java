//Importing Scanner class from util package
import java.util.Scanner;
//Computing average marks of students in three subject and grading them
public class AverageMarksGrades
{
	public static void main(String... argss)
	{
		//Creating object of scanner class
		Scanner sc  = new Scanner(System.in);
		//Taking number of students as input from the user
		int students=sc.nextInt();
		//Declaring three arrays to store marks of students in three subjects
		int[] physics=new int[students];
		int[] chemistry=new int[students];
		int[] mathematics=new int[students];
		//Declaring an array to store percentage[loop] of marks
		double[] percentage=new double[students];
		//initializing a loop to take marks as input from the user
		for(int loop=0;loop<students;loop++)
		{
			physics[loop]=sc.nextInt();
			chemistry[loop]=sc.nextInt();
			mathematics[loop]=sc.nextInt();
			if(physics[loop]<0)
			{
				System.out.println("Please re-enter the marks");
				physics[loop]=sc.nextInt();
			}
			if(chemistry[loop]<0)
			{
				System.out.println("Please re-enter the marks");
				chemistry[loop]=sc.nextInt();
			}
			if(mathematics[loop]<0)
			{
				System.out.println("Please re-enter the marks");
				mathematics[loop]=sc.nextInt();
			}
			percentage[loop]=(physics[loop]+chemistry[loop]+mathematics[loop])/3;
		}
		//printing the result and the grades
		for(int loop=0;loop<students;loop++)
		{
			System.out.println("Marks in Physics : "+physics[loop]);
			System.out.println("Marks in Chemistry : "+chemistry[loop]);
			System.out.println("Marks in Mathematics : "+mathematics[loop]);
			System.out.println("Total Percentage Marks : "+percentage[loop]);
			if(percentage[loop]>=80)
			{
				System.out.println("Grade of Student is A");
				System.out.println("Remark:Level 4, above agency normalized standards");
			}
			else if(percentage[loop]>=70&&percentage[loop]<=79)
			{
				System.out.println("Grade of Student is B");
				System.out.println("Remark:Level 3, at agency normalized standards");
			}
			else if(percentage[loop]>=60&&percentage[loop]<=69)
			{
				System.out.println("Grade of Student is C");
				System.out.println("Remark:Level 2 ,below ,but approaching agency normalized standards");
			}
			else if(percentage[loop]>=50&&percentage[loop]<=59)
			{
				System.out.println("Grade of Student is D");
				System.out.println("Remark:Level 1-,well below agency normalized standards");
			}
			else if(percentage[loop]>=40&&percentage[loop]<=49)
			{
				System.out.println("Grade of Student is E");
				System.out.println("Remark:Level 1-,too below agency normalized standards");
			}
			else
			{
				System.out.println("Grade of Student is R");
				System.out.println("Remark:Remedial Standards");
			}
		}
		//Closing the scanner class
		sc.close();
	}
}