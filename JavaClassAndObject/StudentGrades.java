// Defining a class to calculate grade of a student
public class StudentGrades
{
	// Initializing variables to store details of student
	private String name;
	private long rollNumber;
	private double marks;
	private String grade;
	// Defining constructor to retrieve attributes
	public StudentGrades(String name, long rollNumber, double marks)
	{
		this.name=name;
		this.rollNumber=rollNumber;
		this.marks=marks;
	}
	// Method to assign variables to the student
	public void calculateGrade()
	{
		if(this.marks>90)
		{
			this.grade="A+";
		}
		else if(this.marks<=90 && this.marks>80)
		{
			this.grade="A";
		}
		else if(this.marks<=80 && this.marks>70)
		{
			this.grade="B+";
		}
		else if(this.marks<=70 && this.marks>60)
		{
			this.grade="B";
		}
		else if(this.marks<=40 && this.marks>50)
		{
			this.grade="C";
		}
		else
		{
			this.grade="F";
		}
	}
	// Method to display details
	public void displayDetails()
	{
		System.out.println("Student's Report Card : ");
		System.out.println("Name of the student : "+this.name);
		System.out.println("Roll Number of the student : "+this.rollNumber);
		System.out.println("Marks of the student : "+this.marks);
		System.out.println("Grade of the student : "+this.grade);
	}
}