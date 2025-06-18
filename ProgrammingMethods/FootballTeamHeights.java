// Importing Random class from util package
import java.util.Random;
// Checking the tallest and shortest player, and calculating mean height of players
public class FootballTeamHeights 
{

    // Method to calculate sum of array
    public static int sum(int[] arr) 
    {
        int total = 0;
        for (int height : arr)
        {
            total += height;
        }
        return total;
    }

    // Method to find minimum height
    public static int findMin(int[] arr)
    {
        int min = arr[0];
        for (int height : arr) 
	{
            if (height < min) min = height;
        }
        return min;
    }

    // Method to find maximum height
    public static int findMax(int[] arr)
    {
        int max = arr[0];
        for (int height : arr) 
	{
            if (height > max) max = height;
        }
        return max;
    }

    public static void main(String... args)
    {
	// Declaring an array to store heights of players
        int[] heights = new int[11];
        Random rand = new Random();

        // Generate random heights between 150 and 250 cm
        for (int i = 0; i < 11; i++) 
	{
            heights[i] = rand.nextInt(101) + 150; // 150 to 250
        }

        // Display player heights
        System.out.println("Player heights (in cm):");
        for (int height : heights) 
	{
            System.out.print(height + " ");
        }
        System.out.println();

        // Calculate and display statistics
        double mean = sum(heights) / 11.0;
        int shortest = findMin(heights);
        int tallest = findMax(heights);

        System.out.println("Mean height: "+ mean);
        System.out.println("Shortest player: " + shortest + " cm");
        System.out.println("Tallest player: " + tallest + " cm");
	// Closing Random class
	rand.close();
    }
}
