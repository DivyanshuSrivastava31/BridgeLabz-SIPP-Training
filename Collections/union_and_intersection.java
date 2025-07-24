import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SetOperations {

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> unionResult = union(set1, set2);
        Set<Integer> intersectionResult = intersection(set1, set2);

        System.out.println("Set1: " + set1 + ", Set2: " + set2);
        System.out.println("Union: " + unionResult + ", Intersection: " + intersectionResult);
    }
}