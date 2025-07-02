import java.util.*;

class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

public class Main {

    public static int calculateScore(String[] correctAnswers, String[] userAnswers) throws InvalidQuizSubmissionException {
        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException("Answer count does not match the number of questions.");
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    // Method to return grade based on score
    public static String getGrade(int score, int total) {
        double percentage = (score * 100.0) / total;
        if (percentage >= 90) return "A";
        else if (percentage >= 75) return "B";
        else if (percentage >= 50) return "C";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Correct answers for a sample quiz
        String[] correctAnswers = {"A", "B", "C", "D", "A"};

        // List to store scores of multiple users
        List<Integer> scores = new ArrayList<>();

        System.out.print("Enter number of users: ");
        int userCount = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int u = 1; u <= userCount; u++) {
            System.out.println("\nUser " + u + ": Enter your answers (space-separated, e.g., A B C D A)");
            String[] userAnswers = sc.nextLine().trim().split("\\s+");

            try {
                int score = calculateScore(correctAnswers, userAnswers);
                scores.add(score);
                String grade = getGrade(score, correctAnswers.length);
                System.out.println("Score: " + score + "/" + correctAnswers.length + " | Grade: " + grade);
            } catch (InvalidQuizSubmissionException e) {
                System.out.println("Error: " + e.getMessage());
                scores.add(0); // Optionally
            }
        }

        System.out.println("\nAll User Scores: " + scores);
        sc.close();
    }
}
