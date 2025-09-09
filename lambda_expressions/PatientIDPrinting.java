// Method Reference Example 1: Print Patient IDs
import java.util.*;

public class PatientIDPrinting {
    public static void main(String[] args) {
        List<Integer> patientIDs = Arrays.asList(101, 102, 103, 104);

        // Method reference instead of lambda
        patientIDs.forEach(System.out::println);
    }
}