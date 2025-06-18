// Importing Random class from util package
import java.util.Random;
// Importing Scanner class from util package
import java.util.Scanner;
// Compute a scorecard of students and calculating their percentage marks
public class StudentScorecard 
{

    // Generate random 2-digit scores for PCM subjects
    public static int[][] generateMarks(int numberOfStudents) 
    {
        Random rand = new Random();
        int[][] scores = new int[numberOfStudents][3]; // Columns: Physics, Chemistry, Math
        for (int i = 0; i < numberOfStudents; i++) 
	{
            for (int j = 0; j < 3; j++)
	    {
                scores[i][j] = rand.nextInt(41) + 60; // Scores between 60 and 100
            }
        }
        return scores;
    }

    // Calculate total, average, percentage
    public static double[][] calculateResults(int[][] scores)
    {
        double[][] results = new double[scores.length][3]; // Columns: Total, Average, Percentage
        for (int i = 0; i < scores.length; i++)
	{
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = Math.round(avg * 100.0) / 100.0;
            results[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return results;
    }

    public static void main(String... args) 
    {
	// Creating object of Scanner class
        Scanner sc = new Scanner(System.in);

        // Input number of students from the user
        int n = sc.nextInt();

        int[][] scores = generateMarks(n);
        double[][] results = calculateResults(scores);

        // Print scorecard
        System.out.println("ID\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        for (int i = 0; i < n; i++)
	{
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f%%\n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2],
                    results[i][0], results[i][1], results[i][2]);
        }
	// Closing scanner class
	sc.close();
    }
}
