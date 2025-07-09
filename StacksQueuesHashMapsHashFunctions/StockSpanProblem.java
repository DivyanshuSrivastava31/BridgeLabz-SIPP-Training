import java.util.Stack;

public class StockSpan {

    // Function to calculate span values
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and current price is higher or equal
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, it means price is greatest so far
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push this element's index onto stack
            stack.push(i);
        }

        return span;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] prices = {100, 90, 65, 70, 60, 85, 25};
        int[] span = calculateSpan(prices);

        System.out.println("Stock Prices:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println("\nSpan Values:");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
