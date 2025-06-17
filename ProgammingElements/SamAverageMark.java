//Computing Average Marks of Sam in Maths, Physics and Chemistry
public class SamAverageMark {
    public static void main(String[] args) {
        // Marks obtained by Sam in each subject
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        // Calculate total marks
        int totalMarks = maths + physics + chemistry;

        // Calculate average by dividing total by number of subjects
        double average = totalMarks / 3.0;

        // Print the result
        System.out.println("Sam’s average mark in PCM is " + average);
    }
}
