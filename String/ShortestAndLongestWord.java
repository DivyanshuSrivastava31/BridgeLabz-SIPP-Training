// Importing scanner class from util package
import java.util.Scanner;
// Finding the longest and the shortest word in a text
public class ShortestAndLongestWord 
{

    // Method to get length of a string without using length()
    public static int getLength(String str)
    {
        int count = 0;
        try {
            while (true)
	    {
                str.charAt(count);
                count++;
            }
        } 
	catch (Exception e) 
	{
            // end of string reached
        }
        return count;
    }

    // Method to split the string into words without using split()
    public static String[] customSplit(String text)
    {
        int len = getLength(text);
        int wordCount = 0;

        // Count words
        boolean inWord = false;
        for (int i = 0; i < len; i++) 
	{
            if (text.charAt(i) != ' ') 
	    {
                if (!inWord) 
		{
                    wordCount++;
                    inWord = true;
                }
            } 
	    else
            {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        StringBuilder current = new StringBuilder();
        int index = 0;

        for (int i = 0; i < len; i++) 
	{
            char ch = text.charAt(i);
            if (ch != ' ') 
	    {
                current.append(ch);
            } 
	    else if (current.length() > 0)
	    {
                words[index++] = current.toString();
                current.setLength(0);
            }
        }

        // Add last word if any
        if (current.length() > 0) 
	{
            words[index] = current.toString();
        }

        return words;
    }

    // Method to get word lengths into a 2D array
    public static String[][] getWordsAndLengths(String[] words) 
    {
        String[][] wordLength = new String[words.length][2];
        for (int i = 0; i < words.length; i++) 
	{
            wordLength[i][0] = words[i];
            wordLength[i][1] = String.valueOf(getLength(words[i]));
        }
        return wordLength;
    }

    // Method to find shortest and longest word indices
    public static int[] findMinMax(String[][] wordLength)
    {
        int minIndex = 0, maxIndex = 0;
        int min = Integer.parseInt(wordLength[0][1]);
        int max = min;

        for (int i = 1; i < wordLength.length; i++) 
	{
            int len = Integer.parseInt(wordLength[i][1]);
            if (len < min)
	    {
                min = len;
                minIndex = i;
            }
            if (len > max) 
	    {
                max = len;
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }


    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
        // Taking integer input from the user
        String input = sc.nextLine();

        String[] words = customSplit(input);
        String[][] wordLength = getWordsAndLengths(words);
        int[] minMax = findMinMax(wordLength);

        System.out.println("\nWords and their lengths:");
        for (String[] row : wordLength) 
	{
            System.out.println(row[0] + " => " + row[1]);
        }

        System.out.println("Shortest word: " + wordLength[minMax[0]][0]);
        System.out.println("Longest word: " + wordLength[minMax[1]][0]);
	// Closing scanner class
	sc.close();
    }
}
