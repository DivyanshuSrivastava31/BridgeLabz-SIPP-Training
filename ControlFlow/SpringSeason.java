//Importing Scanner class from util package
import java.util.Scanner;
//Check Whether The Given Date comes within spring season or not
public class SpringSeason
{
	public static void main(String... args)
	{
		//CreatingObject of Scanner Class
		Scanner sc = new Scanner(System.in);
		//Taking input of month and day from the user
		int day=sc.nextInt();
		int month=sc.nextInt();
		//Check whether the month and day comes within Spring Season
		if(month==3&&date>=20&&date<=31)
		{
			System.out.println("Its a Spring Season");
		}
		else if(month==6&&date>=1&&date<=20)
		{
			System.out.println("Its a Spring Season");
		}
		else if(month==4&&date>=1&&date<=30)
		{
			System.out.println("Its a Spring Season");
		}
		else if(month==5&&date>=1&&date<=31)
		{
			System.out.println("Its a Spring Season");
		}
	 	else
		{
			System.out.println("Its not a Spring Season");
		}
		//Closing Scanner Class
		sc.close();
	}
}

				
			
			