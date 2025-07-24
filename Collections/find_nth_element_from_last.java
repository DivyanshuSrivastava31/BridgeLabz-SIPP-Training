import java.util.LinkedList;
import java.util.List;

public class NthElementFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || list.isEmpty() || n <= 0) {
            throw new IllegalArgumentException("Invalid input: list cannot be null or empty, and n must be positive.");
        }

        // Use two pointers: fast and slow
        // Move fast pointer n steps ahead
        // Then move both fast and slow pointers until fast reaches the end
        // When fast reaches the end, slow will be at the Nth element from the end

        T[] array = (T[]) list.toArray(); // Convert to array for direct indexing
        if (n > array.length) {
            throw new IllegalArgumentException("N is greater than the size of the list.");
        }
        return array[array.length - n];
    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');

        int n = 2;
        System.out.println("Input: " + list + ", N=" + n + " → Output: " + findNthFromEnd(list, n));

        n = 1;
        System.out.println("Input: " + list + ", N=" + n + " → Output: " + findNthFromEnd(list, n));

        n = 5;
        System.out.println("Input: " + list + ", N=" + n + " → Output: " + findNthFromEnd(list, n));

        try {
            findNthFromEnd(list, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            findNthFromEnd(list, 6);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}