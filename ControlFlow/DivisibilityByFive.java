//Importing Scanner class from util package
import java.util.Scanner;
//Check a numbers divisibility by five
public class DivisibilityByFive {
    public static void main(String[] args) {
        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Take an input number from user
        int number = sc.nextInt();

        // Check divisibility by 5
        boolean isDivisible = (number % 5 == 0);

        // Print the result
        System.out.println("Is the number " + number + " divisible by 5? " + isDivisible);
        
        // Close the scanner
        sc.close();
    }
}
