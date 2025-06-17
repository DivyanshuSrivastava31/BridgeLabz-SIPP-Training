//Importing Scanner Class from util package
import java.util.Scanner;
//Computing Total Purchase Price from Unit Price and quantity
public class TotalPurchasePrice {
    public static void main(String[] args) {
	//Object of Scanner class
        Scanner sc = new Scanner(System.in);
	//Taking unit Price input from user
        double unitPrice = sc.nextDouble();
	//Taking quantity input from user
        int quantity = sc.nextInt();
	//Calculating Total purchase price from unit price and quantity
        double total = unitPrice * quantity;
	//Printing total price
        System.out.println("Total price: INR " + total);
    }
}
