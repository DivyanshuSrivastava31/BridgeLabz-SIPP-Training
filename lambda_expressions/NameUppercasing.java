// Method Reference Example 2: Uppercase Employee Names
import java.util.*;

public class NameUppercasing {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Alice", "Bob", "Charlie");

        // Using String::toUpperCase in a stream
        employees.stream()
                 .map(String::toUpperCase)
                 .forEach(System.out::println);
    }
}