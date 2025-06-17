//Importing Scanner class from util package
import java.util.*;
//Calculate Simple interest using Principal, Rate and Time values
public class SimpleInterest
{
	//Method to calculate simple interest using principal amount ,rate and time
	void simpleInterest(int principal, int rate, int time)
	{
		//calculate simpleinterest using formula: Principal*rate*time/100
		double simpleinterest=(principal*rate*time)/100;
		//Displaying the result
		System.out.println("The Simple Interest is "+simpleinterest+" for Principal "+principal+", Rate of Interest "+rate+" and Time "+time);
	}
	public static void main(String... args)
	{
		//Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		//Taking inputs from user for principal amount, rate of interest and time period
		int principal=sc.nextInt();
		int rate=sc.nextInt();
		int timeperiod=sc.nextInt();
		//Calling object of the class to invoke the method
		new SimpleInterest().simpleInterest(principal,rate,timeperiod);
		//Closing  scanner class
		sc.close();
	}
}