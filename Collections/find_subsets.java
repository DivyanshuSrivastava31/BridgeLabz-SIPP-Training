import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SubsetChecker {

    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        if (set1 == null || set2 == null) {
            return false; // Or throw IllegalArgumentException, depending on desired behavior
        }
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 5));

        System.out.println("Set1: " + set1 + ", Set2: " + set2 + " → Output: " + isSubset(set1, set2));
        System.out.println("Set3: " + set3 + ", Set2: " + set2 + " → Output: " + isSubset(set3, set2));
    }
}