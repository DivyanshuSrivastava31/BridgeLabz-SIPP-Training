//Importing Scanner Class from util package
import java.util.Scanner;
//Compute the day of the week that the date falls on
public class DayOfTheWeek
{
	public static void main(String... args)
	{
		//Creating object of Scanner Class
		Scanner sc = new Scanner(System.in);
		//Take month , day , year inputs from the user
		//For month use 1 for January, 2 for February, and so forth.
		int month=sc.nextInt();
		int day=sc.nextInt();
		int year=sc.nextInt();
		//Using Gregorian Calendar formulas
		//y0=y-(14-m)/12
		int year_0=year-(14-month)/12;
		//x=y0 + y0/4 - y0/100 + y0/400
		int x=year_0+(year_0/4)-(year_0/100)+(year_0/400);
		//m0=m+12*((14-m)/12)-2
		int month_0=month+12*((14-month)/12)-2;
		//d0 = (d+x+31m0/12)mod 7
		int day_0=(day+x+31month_0/12)%7;
		//Printing the day of the week starting from Sunday as 0
		System.out.println("Day of the Week : "+day_0);
		//Closing scanner class
		sc.close();
	}
}