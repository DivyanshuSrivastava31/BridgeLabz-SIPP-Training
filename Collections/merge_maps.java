import java.util.HashMap;
import java.util.Map;

public class MapMerger {

    public static <K, V extends Number> Map<K, V> mergeMaps(Map<K, V> map1, Map<K, V> map2) {
        Map<K, V> mergedMap = new HashMap<>(map1);

        for (Map.Entry<K, V> entry : map2.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            mergedMap.merge(key, value, (oldValue, newValue) -> {
                // This lambda handles the merging logic when a key exists in both maps
                // It sums the values. This assumes V is a numeric type.
                if (oldValue instanceof Integer) {
                    return (V) Integer.valueOf(oldValue.intValue() + newValue.intValue());
                } else if (oldValue instanceof Double) {
                    return (V) Double.valueOf(oldValue.doubleValue() + newValue.doubleValue());
                }
                // Add more types as needed (Long, Float, etc.)
                return newValue; // Fallback, or throw an exception for unsupported types
            });
        }
        return mergedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> outputMap = mergeMaps(map1, map2);
        System.out.println("Map1: " + map1 + ", Map2: " + map2 + " → Output: " + outputMap);
    }
}