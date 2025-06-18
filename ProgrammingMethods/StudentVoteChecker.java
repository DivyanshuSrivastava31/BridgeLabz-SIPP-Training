// Importing Scanner class from util package
import java.util.Scanner;
// Check whether a student is eligible to vote or not
public class StudentVoteChecker 
{

    // Method to check if a student can vote
    public static boolean canStudentVote(int age) 
    {
        if (age < 0) return false;          // Invalid age
        return age >= 18;                   // Eligible if 18 or more
    }

    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];

        // Input age for 10 students from the user
        for (int i = 0; i < 10; i++) 
	{
            ages[i] = sc.nextInt();

            // Check eligibility
            if (canStudentVote(ages[i])) 
	    {
                System.out.println("Student " + (i + 1) + " can vote.");
            } 
	    else
	    {
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
        }
	// Closing scanner class
	sc.close();

    }
}
