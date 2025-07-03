// Interface defining department behavior
interface Department
{
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract class for Employee
abstract class Employee implements Department 
{
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters (Encapsulation)
    public int getEmployeeId()
    {
        return employeeId;
    }

    public String getName()
    {
        return name;
    }

    public double getBaseSalary()
    {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary)
    {
        this.baseSalary = baseSalary;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails()
    {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: ₹" + baseSalary);
        System.out.println("Department: " + getDepartmentDetails());
        System.out.println("Total Salary: ₹" + calculateSalary());
    }

    // Implement Department methods
    public void assignDepartment(String deptName)
    {
        this.department = deptName;
    }

    public String getDepartmentDetails()
    {
        return department;
    }
}

// Full-time employee class
class FullTimeEmployee extends Employee 
{
    private double fixedBonus;

    public FullTimeEmployee(int id, String name, double baseSalary, double fixedBonus)
    {
        super(id, name, baseSalary);
        this.fixedBonus = fixedBonus;
    }

    public double calculateSalary()
    {
        return getBaseSalary() + fixedBonus;
    }
}

// Part-time employee class
class PartTimeEmployee extends Employee 
{
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double hourlyRate, int workHours)
    {
        super(id, name, hourlyRate * workHours); // baseSalary for part-time can be considered optional
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary()
    {
        return workHours * hourlyRate;
    }
}

// Main class
public class EmployeeManagementSystem 
{
    public static void main(String... args)
    {
        // Using polymorphism
        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee(101, "Alice", 30000, 10000);
        employees[0].assignDepartment("Finance");

        employees[1] = new PartTimeEmployee(102, "Bob", 500, 40);
        employees[1].assignDepartment("Support");

        employees[2] = new FullTimeEmployee(103, "Charlie", 40000, 8000);
        employees[2].assignDepartment("HR");

        // Display details using Employee reference (polymorphism)
        for (Employee emp : employees) 
	{
            emp.displayDetails();
        }
    }
}
