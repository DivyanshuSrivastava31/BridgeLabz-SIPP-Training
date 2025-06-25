// Define a class for a student
class Student
{
    // Initialize variables to store data
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor
    Student(int rollNumber, String name, double CGPA)
    {
	this.rollNumber = rollNumber;
	this.name = name;
	this.CGPA = CGPA;
    }

    // Public getter for CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public setter for CGPA
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    // Method to display student info
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}
// Define a class for post graduate student
class PostgraduateStudent extends Student 
{
    // Initialize variables to store data
    String specialization;

    // Constructor
    PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) 
    {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    // Method to display PG student info
    public void displayPGStudentDetails() 
    {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber);     // public → accessible
        System.out.println("Name: " + name);                  // protected → accessible in subclass
        System.out.println("CGPA: " + getCGPA());             // private → accessed via public method
        System.out.println("Specialization: " + specialization);
    }
}

// Define a class to simulate a university system
public class UniversitySystem 
{
    public static void main(String... args)
    {
        // Base class object
        Student s = new Student(101, "Priya", 8.5);
        System.out.println("Undergraduate Student Details:");
        s.displayStudentDetails();

        // Subclass object
        PostgraduateStudent pg = new PostgraduateStudent(201, "Rahul", 9.0, "Computer Science");
        System.out.println("\n");
        pg.displayPGStudentDetails();

        // Modify CGPA using setter
        pg.setCGPA(9.2);
        System.out.println("\nAfter Updating CGPA:");
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}