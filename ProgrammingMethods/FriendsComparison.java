// Importing Scanner class from util package
import java.util.Scanner;
// Find the youngest and the tallest friend 
public class FriendsComparison 
{

    // Method to find the index of the youngest friend
    public static int findYoungest(int[] ages) 
    {
        int minAge = ages[0];
        int index = 0;
        for (int i = 1; i < ages.length; i++) 
	{
            if (ages[i] < minAge) 
	    {
                minAge = ages[i];
                index = i;
            }
        }
        return index;
    }

    // Method to find the index of the tallest friend
    public static int findTallest(int[] heights) 
    {
        int maxHeight = heights[0];
        int index = 0;
        for (int i = 1; i < heights.length; i++) 
	{
            if (heights[i] > maxHeight) 
	    {
                maxHeight = heights[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String... args) 
    {
        // Creating object of Scanner class
	Scanner sc = new Scanner(System.in);
	// Input ages and heights of 3 friends from the user
        int[] ages = new int[3];
        int[] heights = new int[3];
        String[] names = {"Amar", "Akbar", "Anthony"};

        // Input age and height for each friend
        for (int i = 0; i < 3; i++) 
	{
            ages[i] = sc.nextInt();
            heights[i] = sc.nextInt();
        }

        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        System.out.println("The youngest friend is: " + names[youngestIndex]);
        System.out.println("The tallest friend is: " + names[tallestIndex]);
	// Closing scanner class
	sc.close();

    }
}
