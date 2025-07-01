
import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String sentence = scanner.nextLine();
        System.out.print("Word to replace: ");
        String oldWord = scanner.nextLine();
        System.out.print("New word: ");
        String newWord = scanner.nextLine();

        String result = sentence.replace(oldWord, newWord);
        System.out.println("Modified Sentence: " + result);
    }
}
