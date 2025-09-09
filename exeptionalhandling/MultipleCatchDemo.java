// Problem 4: Multiple Catch Blocks
public class MultipleCatchDemo {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        int index = 5; // Example invalid index

        try {
            int value = numbers[index]; // May throw ArrayIndexOutOfBoundsException
            System.out.println("Value at index " + index + ": " + value);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}