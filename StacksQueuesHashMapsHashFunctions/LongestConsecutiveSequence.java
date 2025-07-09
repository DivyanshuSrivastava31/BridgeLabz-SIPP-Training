import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int maxLength = 0;

        // Add all numbers to set
        for (int num : nums) {
            numSet.add(num);
        }

        // Check each number
        for (int num : nums) {
            // Only start if num is the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int length = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(arr);
        System.out.println("Length of longest consecutive sequence: " + result);
    }
}
