import java.util.Stack;

public class SortStack {

    // Recursive function to sort the stack
    public static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();     // Step 1: Pop
            sort(stack);               // Step 2: Recursively sort remaining
            insert(stack, top);        // Step 3: Insert in sorted order
        }
    }

    // Helper function to insert an element at correct position
    public static void insert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insert(stack, element);
            stack.push(temp);
        }
    }

    // Utility function to print the stack
    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    // Main function to test
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(4);

        System.out.println("Original Stack:");
        printStack(stack);

        sort(stack);

        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}

