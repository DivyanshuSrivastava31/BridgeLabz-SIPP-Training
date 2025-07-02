// Define a class to show employee management system
// Base class: Employee
class Employee 
{
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary)
    {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails()
    {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: ₹" + salary);
    }
}

// Subclass: Manager
class Manager extends Employee
{
    int teamSize;

    public Manager(String name, int id, double salary, int teamSize)
    {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("Role: Manager");
        System.out.println("Team Size: " + teamSize);
    }
}

// Subclass: Developer
class Developer extends Employee 
{
    String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage)
    {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("Role: Developer");
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Subclass: Intern
class Intern extends Employee 
{
    int duration;
    public Intern(String name, int id, double salary, int duration)
    {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("Role: Intern");
        System.out.println("Internship Duration: " + duration + " months");
    }
}

// Main class
public class EmployeeManagementSystem 
{
    public static void main(String... args)
    {
        Manager manager = new Manager("Alice", 101, 80000, 5);
        Developer developer = new Developer("Bob", 102, 60000, "Java");
        Intern intern = new Intern("Charlie", 103, 15000, 6);

        System.out.println(" Manager Details :");
        manager.displayDetails();

        System.out.println("Developer Details :");
        developer.displayDetails();

        System.out.println(" Intern Details :");
        intern.displayDetails();
    }
}
