import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryNumberGenerator {

    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("N=" + n + " → Output: " + generateBinaryNumbers(n));

        n = 10;
        System.out.println("N=" + n + " → Output: " + generateBinaryNumbers(n));
    }
}