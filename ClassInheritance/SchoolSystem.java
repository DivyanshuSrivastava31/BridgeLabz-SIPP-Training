// Importing scanner class from util package
import java.util.Scanner;

// Define a class to store details of a Person
class Person
{
	String name
	int age;
}

// Define a class for teacher, student and staff
class Teacher extends Person // Hierarchical Inheritance
{
	String subject;
	public Teacher(String name, int age, String subject)
	{
		this.name=name;
		this.age=age;
		this.subject=subject;
	}
	void displayRole()
	{
		System.out.println("Person Details : ");
		System.out.println("Name of the person : "+name);
		System.out.println("Age of the person : "+age);
		System.out.println("Role of the person : Teacher");
		System.out.println("Subject taught : "+subject); 
	}
}

class Student extends Person // Hierarchical Inheritance
{
	String grade;
	public Student(String name, int age, String grade)
	{
		this.name=name;
		this.age=age;
		this.grade=grade;
	}
	void displayRole()
	{
		System.out.println("Person Details : ");
		System.out.println("Name of the person : "+name);
		System.out.println("Age of the person : "+age);
		System.out.println("Role of the person : Student");
		System.out.println("Grade obtained : "+grade);
	}
}

class Staff extends Person // Hierarchical Inheritance
{
	int floorAppointed;
	public Staff(String name, int age, int floorAppointed)
	{
		this.name=name;
		this.age=age;
		this.floorAppointed=floorAppointed;
	}
	void displayRole()
	{
		System.out.println("Person Details : ");
		System.out.println("Name of the person : "+name);
		System.out.println("Age of the person : "+age);
		System.out.println("Role of the person : Staff");
		System.out.println("Floor appointed at : "+floorAppointed);
	}
}

// Defining main class
public class SchoolSystem
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Input person details from the user
		System.out.println("Enter name and age of the person : ");
		String name=sc.nextLine();
		int age=sc.nextInt();
		System.out.println("Enter if the person teaches subject else 0 : ");
		String subject=sc.nextLine();
		System.out.println("Enter if the person has a grade else 0 : ");
		String grade=sc.nextLine();
		System.out.println("Enter if the person is appointed at a floor else 0 : ");
		int floor=sc.nextInt();
		if(floor==0&&grade.equalsIgnoreCase("0"))
		{
			Teacher teacher = new Teacher(name,age,subject);
			teacher.displayRole();
		}
		if(subject.equalsIgnoreCase("0")&&floor==0)
		{
			Student student = new Student(name,age,grade);
			student.displayRole();
		}
		if(subject.equalsIgnoreCase("0")&&grade.equalsIgnoreCase("0"))
		{
			Staff staff = new Staff(name,age,floor);
			staff.displayRole();
		}
	}
}