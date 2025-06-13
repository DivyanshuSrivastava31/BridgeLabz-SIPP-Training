//Importing Scanner class from util package
import java.util.Scanner;
//Converting height into inches and feet from cm
public class HeightConverter {
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking input from user for height in cm
        double heightCm = input.nextDouble();

        // Convert cm to total inches
        double totalInches = heightCm / 2.54;

        // Convert inches to feet and remaining inches
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;

        // Display result
        System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f\n",
                          heightCm, feet, inches);

        // Close scanner
        sc.close();
    }
}
