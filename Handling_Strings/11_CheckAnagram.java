
import java.util.Arrays;
import java.util.Scanner;

public class CheckAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();

        char[] arr1 = s1.replaceAll("\s", "").toCharArray();
        char[] arr2 = s2.replaceAll("\s", "").toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) System.out.println("Strings are anagrams");
        else System.out.println("Strings are not anagrams");
    }
}
