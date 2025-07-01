
import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scanner.nextLine();
        System.out.print("Enter the substring: ");
        String sub = scanner.nextLine();
        int count = 0, index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }

        System.out.println("Occurrences: " + count);
    }
}
