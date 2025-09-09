// Problem 9: Nested try-catch
public class NestedTryCatchDemo {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int index = 5;
        int divisor = 0;

        try {
            try {
                int value = arr[index]; // May throw ArrayIndexOutOfBoundsException
                System.out.println("Element: " + value);

                int result = value / divisor; // May throw ArithmeticException
                System.out.println("Result: " + result);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}