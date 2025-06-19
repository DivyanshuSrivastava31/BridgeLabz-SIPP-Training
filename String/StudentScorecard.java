// Importing Random class from util package
import java.util.Random;
// Computing a student scorecard based on their percentage marks and grades
public class StudentScorecard 
{

    // Method to generate random scores for n students in PCM subjects
    public static int[][] generateScores(int n)
    {
        Random rand = new Random();
        int[][] scores = new int[n][3]; // 3 subjects

        for (int i = 0; i < n; i++) 
	{
            scores[i][0] = 50 + rand.nextInt(51); // Physics
            scores[i][1] = 50 + rand.nextInt(51); // Chemistry
            scores[i][2] = 50 + rand.nextInt(51); // Math
        }
        return scores;
    }

    // Method to calculate total, average, and percentage
    public static double[][] calculateResults(int[][] scores)
    {
        double[][] results = new double[scores.length][3]; // total, avg, %, rounded
        for (int i = 0; i < scores.length; i++) 
	{
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = Math.round((avg) * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = avg;
            results[i][2] = percent;
        }
        return results;
    }

    // Method to assign grade based on percentage
    public static String[] assignGrades(double[][] results)
    {
        String[] grades = new String[results.length];
        for (int i = 0; i < results.length; i++) 
	{
            double percent = results[i][2];
            if (percent >= 90)
                grades[i] = "A+";
            else if (percent >= 80)
                grades[i] = "A";
            else if (percent >= 70)
                grades[i] = "B";
            else if (percent >= 60)
                grades[i] = "C";
            else if (percent >= 50)
                grades[i] = "D";
            else
                grades[i] = "F";
        }
        return grades;
    }

    // Method to display the scorecard
    public static void displayScorecard(int[][] scores, double[][] results, String[] grades)
    {
        for (int i = 0; i < scores.length; i++) 
	{
            System.out.println("Marks of the student in three subjects : "+scores[i][0]+" , "+scores[i][1]+" , "+scores[i][2]);
	    System.out.println("Results computed : Total - "+results[i][0]+" , Average - "+results[i][1]+" , Percentage - "+results[i][2]);
	    System.out.println("Grades assigned : "+grades[i]); 
        }
    }

    public static void main(String... args)
    {
        int students = 10; // number of students
        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        String[] grades = assignGrades(results);
        displayScorecard(scores, results, grades);
    }
}
