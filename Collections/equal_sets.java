import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SetEqualityChecker {

    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        if (set1 == null || set2 == null) {
            return set1 == set2; // Both null means equal, one null and one not means not equal
        }
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Set1: " + set1 + ", Set2: " + set2 + " → Output: " + areSetsEqual(set1, set2));
        System.out.println("Set1: " + set1 + ", Set3: " + set3 + " → Output: " + areSetsEqual(set1, set3));
    }
}