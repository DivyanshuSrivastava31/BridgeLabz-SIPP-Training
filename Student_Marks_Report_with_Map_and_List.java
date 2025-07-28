import java.util.*;

public class StudentMarksReport {
    private Map<String, List<Integer>> studentMarks;

    public StudentMarksReport() {
        studentMarks = new HashMap<>();
    }

    // Add new marks for a student
    public void addMarks(String studentName, List<Integer> marks) {
        studentMarks.putIfAbsent(studentName, new ArrayList<>());
        studentMarks.get(studentName).addAll(marks);
    }

    // Calculate average marks for a student
    public double getAverage(String studentName) {
        List<Integer> marks = studentMarks.get(studentName);
        if (marks == null || marks.isEmpty()) return 0.0;

        double sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / marks.size();
    }

    // Get top-performing student
    public String getTopStudent() {
        String topStudent = null;
        double highestAverage = 0.0;

        for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
            double avg = getAverage(entry.getKey());
            if (avg > highestAverage) {
                highestAverage = avg;
                topStudent = entry.getKey();
            }
        }
        return topStudent;
    }

    // Optional: Display all students and their marks
    public void printReport() {
        for (String student : studentMarks.keySet()) {
            System.out.println(student + ": " + studentMarks.get(student) +
                               " -> Average: " + getAverage(student));
        }
    }

    // Main method to demonstrate
    public static void main(String[] args) {
        StudentMarksReport report = new StudentMarksReport();

        report.addMarks("Alice", Arrays.asList(85, 90, 78));
        report.addMarks("Bob", Arrays.asList(92, 88, 95));
        report.addMarks("Charlie", Arrays.asList(70, 68, 72));

        report.printReport();

        System.out.println("Top Student: " + report.getTopStudent());
    }
}
