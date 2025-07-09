import java.util.*;

public class PairWithGivenSum {

    // Function to check for a pair with given sum
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 6};
        int target = 10;

        if (!hasPairWithSum(arr, target)) {
            System.out.println("No pair found with sum " + target);
        }
    }
}
