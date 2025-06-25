// Importing scanner class from util package
import java.util.Scanner
// Main class to define the object of StudentGrades class
public class MainStudentGrades
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking name, roll number and marks of the student from the user
		String name=sc.nextLine();
		long rollNumber=sc.nextLong();
		double marks=sc.nextDouble();
		// Creating object and calling method to calculate grade and display details
		StudentGrades objGrade = new StudentGrades(name,rollNumber,marks);
		objGrades.calculateGrade();
		objGrades.displayDetails();
		// Closing object of scanner class
		sc.close();
	}
}