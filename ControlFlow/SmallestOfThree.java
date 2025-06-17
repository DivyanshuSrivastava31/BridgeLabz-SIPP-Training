
//Importing Scanner class from util package
import java.util.Scanner;
//Check whether first number is smallest among the three numbers or not
public class SmallestOfThree {
    public static void main(String[] args) {
        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Input 3 numbers from user
     
	int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();
	// Initialize a variable to check if number one is smallest
	boolean isSmallest;
        // Check whether first number is the smallest
        if(number1<number2)
	{
		if(number1<number3)
		{
			isSmallest=true;
		}
		else
		{
			isSmallest=false;
		}
	}
        // Output the result
        System.out.println("Is the first number the smallest? " + isSmallest);

        // Close the scanner
        sc.close();
    }
}
