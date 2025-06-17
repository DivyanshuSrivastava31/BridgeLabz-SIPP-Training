//Importing Scanner class from util package
import java.util.Scanner;
//Compute Mean height of players in a football team
public class MeanHeightOfFootballTeam
{
	public static void main(String... args)
	{
		//Creating object of Scanner class
		Scanner sc = new Scanner(System.in);
		//initializing a double array to store heights of the players
		double[] height= new double[11];
		//initialize a variable to store sum of heights
		double sum=0.0;
		//initialize a loop to take heights from the user and compute the sum
		for(int loop=0;loop<11;loop++)
		{
			height[loop]=sc.nextDouble();
			sum+=height[loop];
		}
		//Printing average height of the players
		System.out.println("Average height of the players in the football team : "+(sum/11));
		//Closing scanner class
		sc.close();
	}
}
		