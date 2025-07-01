
import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) result.append(Character.toLowerCase(c));
            else if (Character.isLowerCase(c)) result.append(Character.toUpperCase(c));
            else result.append(c);
        }

        System.out.println("Toggled String: " + result);
    }
}
