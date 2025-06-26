// Define a class to display student details
public class Student
{
	// static variable to store number of students
	static int totalStudents=0;
	static String college="GLA University";
	// initialize variable to store data
	private String name;
	private String grade;
	// Final variable to store roll number
	final long rollNumber;
	// Define a constructor
	public Student(String name, String grade, long rollNumber)
	{
		this.name=name;
		this.grade=grade;
		this.rollNumber=rollNumber;
		totalStudents++;
	}
	// Method to display details
	void displayDetails()
	{
		if(this instanceof Student)
		{
			System.out.println("Student details : ");
			System.out.println("Name of the student : "+name);
			System.out.println("Roll number of the student : "+rollNumber);
			System.out.println("Grade of the student : "+grade);
		}
		else
			System.out.println("Invalid object created");
	}
	// Method to upgrade grades
	void updateGrade(String grade)
	{
		if(this instanceof Student)
		{
			this.grade=grade;
		}
		else
			System.out.println("Invalid object created");
	}
	// Method to display total number of students
	void displayTotalStudents()
	{
		System.out.println("Total number of students in the university : "+totalStudents);
	}
	// Main method
	public static void main(String... args)
	{
		Student student1 = new Student("Amritanshu Gupta","A",2215000220);
		Student student2 = new Student("Parth Agarwal","B",2215001234);
		student1.displayDetails();
		student2.updateGrade("A");
		student2.displayDetails();
		student2.displayTotalStudents();
	}
}