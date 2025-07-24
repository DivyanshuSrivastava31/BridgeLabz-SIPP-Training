import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxValueKeyFinder {

    public static <K> K findKeyWithHighestValue(Map<K, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        K maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        String result = findKeyWithHighestValue(inputMap);
        System.out.println("Input: " + inputMap + " → Output: " + result);

        Map<String, Integer> emptyMap = new HashMap<>();
        System.out.println("Input: " + emptyMap + " → Output: " + findKeyWithHighestValue(emptyMap));
    }
}