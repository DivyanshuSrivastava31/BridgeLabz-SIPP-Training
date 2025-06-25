// Define a class to create a Course in an instituition
public class Course 
{
    // Initialize variables to store data
    String courseName;
    int duration; // in weeks
    double fee;
    static String instituteName = "ABC Institute"; // class variable

    // Constructor
    Course(String courseName, int duration, double fee) 
    {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    void displayCourseDetails() 
    {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
    }

    // Class method to update institute name
    static void updateInstituteName(String name) 
    {
        instituteName = name;
    }

    // Main method to test
    public static void main(String... args) 
    {
        Course c1 = new Course("Java Programming", 6, 6000.0);
        Course c2 = new Course("Web Development", 8, 7500.0);

        System.out.println("Course 1 Details:");
        c1.displayCourseDetails();

        System.out.println("\nCourse 2 Details:");
        c2.displayCourseDetails();

        // Updating institute name using class method
        Course.updateInstituteName("Global Tech Academy");

        System.out.println("\nAfter Updating Institute Name:");

        System.out.println("\nCourse 1 Details:");
        c1.displayCourseDetails();

        System.out.println("\nCourse 2 Details:");
        c2.displayCourseDetails();
    }
}