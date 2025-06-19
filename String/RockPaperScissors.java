// Importing Scanner class and random class from util package
import java.util.Scanner;
import java.util.Random;
// Determining the winner between user and computer
public class RockPaperScissors 
{

    // Get computer choice randomly
    public static String getComputerChoice()
    {
        String[] options = {"Rock", "Paper", "Scissors"};
        return options[new Random().nextInt(3)];
    }

    // Determine winner between user and computer
    public static String getWinner(String user, String computer)
    {
        if (user.equals(computer)) 
	    return "Draw";
        if ((user.equals("Rock") && computer.equals("Scissors")) ||
            (user.equals("Paper") && computer.equals("Rock")) ||
            (user.equals("Scissors") && computer.equals("Paper")))
    	{
            return "User";
        }
        return "Computer";
    }

    // Method to calculate and return win percentages
    public static String[] calculateStats(int userWins, int computerWins, int totalGames)
    {
        double userPercent = ((double) userWins / totalGames) * 100;
        double compPercent = ((double) computerWins / totalGames) * 100;

        return new String[] 
	{
            String.format("%.2f", userPercent) + "%",
            String.format("%.2f", compPercent) + "%"
        };
    }

    // Main function
    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
	// Taking number of games to be played as input from the user
        int games = sc.nextInt();

        int userWins = 0, compWins = 0, draws = 0;

        System.out.println("Enter your choice (Rock/Paper/Scissors):");

        for (int i = 1; i <= games; i++) 
	{
            System.out.print("Game " + i + " - Your choice: ");
            String user = sc.nextLine().trim();

            String computer = getComputerChoice();
            String winner = getWinner(user, computer);

            // Update scores
            if (winner.equals("User")) 
	        userWins++;
            else if (winner.equals("Computer")) 
		compWins++;
            else 
		draws++;
        }

        // Calculate stats
        String[] percentages = calculateStats(userWins, compWins, games);

        // Display final stats
        System.out.println("Game Summary");
        System.out.println("Total Games: " + games);
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + compWins);
        System.out.println("Draws: " + draws);
        System.out.println("User Win %: " + percentages[0]);
        System.out.println("Computer Win %: " + percentages[1]);
	// Closing scanner class
	sc.close();
    }
}
