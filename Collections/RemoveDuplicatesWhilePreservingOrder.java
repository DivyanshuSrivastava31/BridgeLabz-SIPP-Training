import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Set;

public class DuplicateRemover {

    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>(); // LinkedHashSet preserves insertion order
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (seen.add(element)) { // add returns true if the element was not already present
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> output = removeDuplicates(input);
        System.out.println("Input: " + input + " → Output: " + output);
    }
}