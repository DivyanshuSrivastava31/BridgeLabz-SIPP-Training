// Problem 2: Unchecked Exception
import java.util.*;

public class UncheckedExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int num1 = sc.nextInt();

            System.out.print("Enter denominator: ");
            int num2 = sc.nextInt();

            int result = num1 / num2;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Error: Division by zero not allowed!");
        }
        catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values!");
        }
    }
}