
import java.util.Scanner;

public class RemoveSpecificCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Character to Remove: ");
        char ch = scanner.next().charAt(0);
        String result = input.replace(Character.toString(ch), "");
        System.out.println("Modified String: " + result);
    }
}
