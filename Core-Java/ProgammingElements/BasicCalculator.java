//Importing Scanner class from util package
import java.util.Scanner;
//Computing basic calculator operations
public class BasicCalculator {
    public static void main(String[] args) {
        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Taking input for two numbers
        double number1 = input.nextDouble();
        double number2 = input.nextDouble();

        // Perform basic arithmetic operations
        double sum = number1 + number2;
        double difference = number1 - number2;
        double product = number1 * number2;
        double quotient = number1 / number2;

        // Display results
        System.out.printf("The addition, subtraction, multiplication and division value of 2 numbers %.2f and %.2f is %.2f, %.2f, %.2f and %.2f\n",
                          number1, number2, sum, difference, product, quotient);

        // Close the scanner
        sc.close();
    }
}
