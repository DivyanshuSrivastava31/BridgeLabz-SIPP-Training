// Importing scanner and random class from util package
import java.util.Scanner;
import java.util.Random;
// Check if the number guessed by user and computer is same or not
public class NumberGuessingGame 
{

    public static void main(String... args)
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
        System.out.println("Think of a number between 1 and 100, and I will try to guess it!");
        System.out.println("Respond with: 'low' if my guess is too low, 'high' if it's too high, and 'correct' if I got it!");

        int low = 1;
        int high = 100;
        boolean correct = false;
	// Looping to check if the guess is lower, higher or equal
        while (!correct && low <= high)
	{
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "?");

            String feedback = getUserFeedback(scanner);

            switch (feedback.toLowerCase())
	    {
                case "low":
                    low = guess + 1;
                    break;
                case "high":
                    high = guess - 1;
                    break;
                case "correct":
                    System.out.println("Yay! I guessed your number correctly!");
                    correct = true;
                    break;
                default:
                    System.out.println("Invalid input. Please type 'low', 'high', or 'correct'.");
            }
        }

        if (!correct) {
            System.out.println("It seems there was a mistake in feedback. Let's try again!");
        }
	// Closing scanner class	
        sc.close();
    }

    // Method to generate a guess within the given range
    public static int generateGuess(int low, int high) {
        return low + (high - low) / 2; // Binary search strategy (smarter than random)
        // For random guess instead, use:
        // return new Random().nextInt(high - low + 1) + low;
    }

    // Method to get feedback from the user
    public static String getUserFeedback(Scanner scanner) {
        System.out.print("Enter your feedback (low/high/correct): ");
        return scanner.nextLine();
    }
}
