import java.util.function.Function;

public class StringLengthCheck {
    public static void main(String[] args) {
        Function<String, Integer> lengthFunc = str -> str.length();
        String msg = "Hello Functional Interface!";
        System.out.println("Message length: " + lengthFunc.apply(msg));
    }
}