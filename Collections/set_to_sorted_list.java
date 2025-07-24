import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class SetToSortedListConverter {

    public static <T extends Comparable<T>> List<T> convertSetToSortedList(Set<T> set) {
        List<T> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> outputList = convertSetToSortedList(inputSet);
        System.out.println("Input: " + inputSet + " → Output: " + outputList);
    }
}