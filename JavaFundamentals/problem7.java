import java.util.Scanner;

public class _7Perimeter_of_Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();

        double perimeter = 2 * (length + width);

        System.out.println("Perimeter of the rectangle: " + perimeter);

        scanner.close();
    }
}