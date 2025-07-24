import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    private String name;
    private int severity; // Higher number means higher severity

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + severity + ")";
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {
        // PriorityQueue orders elements based on their natural ordering or by a Comparator
        // We want higher severity to be treated first, so we reverse the natural order of severity
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(Comparator.comparingInt(Patient::getSeverity).reversed());

        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));
        triageQueue.add(new Patient("David", 3));

        System.out.println("Patients: " + Arrays.asList(new Patient("John", 3), new Patient("Alice", 5), new Patient("Bob", 2)));
        System.out.print("Order: ");
        while (!triageQueue.isEmpty()) {
            System.out.print(triageQueue.poll().getName());
            if (!triageQueue.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}