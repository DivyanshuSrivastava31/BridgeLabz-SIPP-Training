//Computing the number of pens Distributed among students
public class PenDistribution {
    public static void main(String[] args) {
        // Total pens and number of students
        int totalPens = 14;
        int students = 3;

        // Pens each student will get
        int pensPerStudent = totalPens / students;

        // Remaining pens that cannot be equally distributed
        int remainingPens = totalPens % students;

        // Output the result
        System.out.println("The Pen Per Student is " + pensPerStudent + 
                           " and the remaining pen not distributed is " + remainingPens);
    }
}
