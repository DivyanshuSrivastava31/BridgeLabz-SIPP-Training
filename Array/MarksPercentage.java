//Importing Scanner class from util package
import java.util.Scanner;
//Computing marks of 3 subjects of students and calculating average
public class MarksPercentage
{
	public static void main(String... args)
	{
		//Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		//Taking number of students input from the user
		int students=sc.nextInt();
		//Declare a 2-D array to store marks of subjects
		int[][] subjectmarks=new int[students][3];
		//Taking marks input from the user
		for(int loop1=0;loop1<students;loop1++)
		{
			for(int loop2=0;loop2<3;loop2++)
			{
				subjectmarks[loop1][loop2]=sc.nextInt();
			}
		}
		double[] percentage=new double[students];
		for(int loop=0;loop<students;loop++)
		{
			percentage[loop]=(subjectmarks[loop][0]+subjectmarks[loop][1]+subjectmarks[loop][2])/3;
		}
		//printing the result and the grades
		for(int loop=0;loop<students;loop++)
		{
			System.out.println("Marks in Physics : "+subjectmarks[loop][0]);
			System.out.println("Marks in Chemistry : "+subjectmarks[loop][1]);
			System.out.println("Marks in Mathematics : "+subjectmarks[loop][2]);
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