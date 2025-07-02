// Importing scanner class from util package
import java.util.Scanner;

// Define a class to store details of the course
class Course
{
	String courseName;
	double duration;
}

// Define a class to store details of the online course
class OnlineCourse extends Course // Single Inheritance
{
	String platform;
	String isRecorded;
}

// Define a class to store fees details and discount
class PaidOnlineCourse extends OnlineCourse // Multilevel Inheritance
{
	int fees;
	int discount;
	public PaidOnlineCourse(String name, double time, String platform, string record, int fees, int discount)
	{
		courseName = name;
		duration = time;
		this.platform = platform;
		isRecorded=record;
		this.fees=fees;
		this.discount=discount;
	}
	// Method to display details
	void displayInfo()
	{
		System.out.println("Course Details : ");
		System.out.println("Course Name : "+courseName);
		System.out.println("Course duration : "+duration);
		System.out.println("Platform of the course : "+platform);
		System.out.println("Is the course recorded ? : "+isRecorded);
		System.out.println("Fees of the course : "+fees);
		System.out.println("Discount provided : "+discount);
	}
}

// Defining main class
public class EducationCourse
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Input details from the user
		System.out.println("Enter course name, duration , platform, whether it is recorded or not, fees and discount of the course : ");
		String name=sc.nextLine();
		double time=sc.nextDouble(); 
		String platform=sc.nextLine(); 
		String record=sc.nextLine(); 
		int fees=sc.nextInt(); 
		int discount=sc.nextInt();
		// Object creating and method calling
		PaidOnlineCourse paidCourse = new PaidOnlineCourse(name,time,platform,record,fees,discount);
		paidCourse.displayInfo();
	}
}