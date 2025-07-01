
import java.util.Scanner;

public class LongestWordInSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String[] words = scanner.nextLine().split(" ");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) longest = word;
        }

        System.out.println("Longest word: " + longest);
    }
}
