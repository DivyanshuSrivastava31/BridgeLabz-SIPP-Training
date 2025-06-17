//Importing Scanner class from util package
import java.util.Scanner;
//Check if the student is eligible to vote or not
public class EligibilityToVote
{
	public static void main(String... args)
	{
		//Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		//Declaring a 1-D Array
		int[] students=new int[10];
		//initialize a loop to input elements from the user
		for(int loop=0;loop<10;loop++)
		{
			students[loop]=sc.nextInt();
			if(students[loop]>=18)
				System.out.println("Student "+(loop+1)+" is eligible to vote");
			else
				System.out.println("Student "+(loop+1)+" is not eligible to vote");
		}
		//Closing scanner class
		sc.close();
	}
}