//Importing Scanner Class from util package
import java.util.Scanner;
//Check among three persons who is the tallest and who is the youngest
public class AgeHeight
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//Taking age inputs of Amar, Akbar, Anthony
		int age_amar=sc.nextInt();
		int age_akbar=sc.nextInt();
		int age_anthony=sc.nextInt();
		//Taking height inputs of Amar, Akbar, Anthony
		double height_amar=sc.nextDouble();
		double height_akbar=sc.nextDouble();
		double height_anthony=sc.nextDouble();
		//Checking who is the youngest among them
		if(age_amar<age_akbar)
		{
			if(age_amar<age_anthony)
			{
				System.out.println("Amar is the youngest of them all");
			}
			else
			{
				System.out.println("Anthony is the youngest of them all");
			}
		}
		else if(age_akbar<age_anthony)
		{
			System.out.println("Akbar is the youngest of them all");
		}
		else
		{
			System.out.println("Anthony is the youngest of them all");
		}
		//Checking who is the oldest among them
		if(height_amar>height_akbar)
		{
			if(height_amar>height_anthony)
			{
				System.out.println("Amar is the tallest of them all");
			}
			else
			{
				System.out.println("Anthony is the tallest of them all");
			}
		}
		else if(height_akbar>height_anthony)
		{
			System.out.println("Akbar is the tallest of them all");
		}
		else
		{
			System.out.println("Anthony is the tallest of them all");
		}
		//Closing the scanner class
		sc.close();
	}
}