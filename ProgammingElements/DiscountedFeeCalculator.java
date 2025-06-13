//Importing Scanner class from util package
import java.util.Scanner;
//Computing discounted fee from user input fee and discount percent
public class DiscountedFeeCalculator {
    public static void main(String[] args) {
        // Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Taking input from user for fee
        double fee = input.nextDouble();

        //Taking input from user for discount percentage
        double discountPercent = input.nextDouble();

        // Calculate discount amount
        double discount = (discountPercent / 100) * fee;

        // Calculate final fee after discount
        double finalFee = fee - discount;

        // Display the result
        System.out.println("The discount amount is INR " + discount + 
                           " and final discounted fee is INR " + finalFee);

        // Close the scanner
        sc.close();
    }
}
