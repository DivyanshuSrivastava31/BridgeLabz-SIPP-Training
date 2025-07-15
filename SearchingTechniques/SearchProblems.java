import java.util.Arrays;

public class SearchProblems {

    // Linear Search: Find the first missing positive integer
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Mark numbers outside the range [1, n] as n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Mark presence of numbers by negative marking
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val <= n) {
                nums[val - 1] = -Math.abs(nums[val - 1]);
            }
        }

        // Step 3: Find first index with a positive value
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // If all numbers from 1 to n are present
        return n + 1;
    }

    // Binary Search: Find index of target in sorted array
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1, 7, 5};
        int target = 4;

        // Make a copy since firstMissingPositive modifies the array
        int[] numsCopy = Arrays.copyOf(nums, nums.length);

        // Find first missing positive
        int missing = firstMissingPositive(numsCopy);
        System.out.println("First Missing Positive Integer: " + missing);

        // Sort array for binary search
        Arrays.sort(nums);
        int index = binarySearch(nums, target);
        System.out.println("Sorted Array: " + Arrays.toString(nums));
        System.out.println("Index of target " + target + ": " + index);
    }
}
