import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues<T> {
    private Queue<T> q1; // Main queue
    private Queue<T> q2; // Helper queue

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push operation: O(N) where N is the number of elements in the stack
    public void push(T x) {
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        // Add new element to q1
        q1.add(x);
        // Move all elements back from q2 to q1
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    // Pop operation: O(1)
    public T pop() {
        if (isEmpty()) {
            return null; // Or throw NoSuchElementException
        }
        return q1.remove();
    }

    // Top operation: O(1)
    public T top() {
        if (isEmpty()) {
            return null; // Or throw NoSuchElementException
        }
        return q1.peek();
    }

    // IsEmpty operation
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();
        System.out.print("Push 1, 2, 3 → ");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Pop → Output: " + stack.pop()); // Should be 3
        System.out.println("Top: " + stack.top()); // Should be 2
        System.out.println("Pop → Output: " + stack.pop()); // Should be 2
        System.out.println("Is Empty: " + stack.isEmpty()); // Should be false
        System.out.println("Pop → Output: " + stack.pop()); // Should be 1
        System.out.println("Is Empty: " + stack.isEmpty()); // Should be true
    }
}