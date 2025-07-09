import java.util.*;

public class SlidingWindowMaximum {

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < nums.length; i++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove indices whose values are less than current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index to deque
            deque.offerLast(i);

            // Add the front of deque to result once we have a complete window
            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> result = maxSlidingWindow(arr, k);

        System.out.println("Sliding Window Maximums:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
