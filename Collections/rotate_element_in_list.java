import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class ListRotator {

    public static <T> void rotateList(List<T> list, int positions) {
        if (list == null || list.isEmpty() || positions == 0) {
            return;
        }

        int size = list.size();
        positions = positions % size; // Handle cases where positions > size
        if (positions < 0) {
            positions += size; // Handle negative positions for left rotation
        }

        // Perform rotation by splitting and re-adding elements
        List<T> sublist1 = new ArrayList<>(list.subList(0, positions));
        List<T> sublist2 = new ArrayList<>(list.subList(positions, size));

        list.clear();
        list.addAll(sublist2);
        list.addAll(sublist1);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;
        System.out.println("Input: " + list + ", rotate by " + rotateBy);
        rotateList(list, rotateBy);
        System.out.println("Output: " + list);
    }
}