// Importing scanner and random class from util package
import java.util.Random;
import java.util.Scanner;
// Check whether the students are eligible to vote or not
public class VotingEligibility 
{

    // Method to generate random 2-digit ages for 'n' students
    public static int[] generateAges(int n)
    {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) 
	{
            ages[i] = rand.nextInt(100); // Age between 0–99
        }
        return ages;
    }

    // Method to check voting eligibility
    public static String[][] checkEligibility(int[] ages)
    {
        String[][] result = new String[ages.length][2]; // [age, eligibility]
        for (int i = 0; i < ages.length; i++) 
	{
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] >= 18) 
	    {
                result[i][1] = "Can Vote";
            }
            else if (ages[i] < 0)
	    {
                result[i][1] = "Invalid Age";
            }
   	    else
	    {
                result[i][1] = "Cannot Vote";
            }
        }
        return result;
    }

    // Method to display the result in a tabular format
    public static void displayResults(String[][] data)
    {
        System.out.println("S.No\tAge\tEligibility");
        for (int i = 0; i < data.length; i++) 
	{
            System.out.println((i + 1) + "\t" + data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Ask for number of students from the user
        int students = sc.nextInt();

        int[] ages = generateAges(students);
        String[][] eligibility = checkEligibility(ages);
        displayResults(eligibility);
    }
}
