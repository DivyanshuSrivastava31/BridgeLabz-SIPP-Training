// Problem 3: Custom Exception
import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");

        try {
            int age = sc.nextInt();
            validateAge(age);
        }
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}