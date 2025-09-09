// Problem 7: finally Block
import java.util.*;

public class FinallyDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();

            int result = a / b;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        }
        finally {
            System.out.println("Operation completed");
        }
    }
}