import java.util.*;

public class ZeroSumSubarrays {

    // Function to find all subarrays with sum 0
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumIndexMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        // Initialize map with sum = 0 at index -1 to handle subarrays starting from index 0
        sumIndexMap.put(0, new ArrayList<>());
        sumIndexMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumIndexMap.containsKey(sum)) {
                for (int startIndex : sumIndexMap.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            sumIndexMap.putIfAbsent(sum, new ArrayList<>());
            sumIndexMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};

        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays:");
        for (int[] range : subarrays) {
            System.out.println("From index " + range[0] + " to " + range[1]);
        }
    }
}
