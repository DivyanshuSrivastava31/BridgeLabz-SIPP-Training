// Define a class for an employee
class Employee 
{
    public int employeeID;           // Public: accessible everywhere
    protected String department;     // Protected: accessible in subclass
    private double salary;           // Private: accessible only within this class

    // Constructor
    public Employee(int employeeID, String department, double salary) 
    {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Getter for salary
    public double getSalary() 
    {
        return salary;
    }

    // Setter for salary
    public void setSalary(double salary) 
    {
        this.salary = salary;
    }

    // Method to display employee info
    public void displayEmployeeInfo() 
    {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

// Define a class for a manager 
class Manager extends Employee  
{
    private int teamSize;

    // Constructor
    public Manager(int employeeID, String department, double salary, int teamSize) 
    {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    // Method to display manager info
    public void displayManagerInfo() 
    {
        System.out.println("Manager ID: " + employeeID);       //  public - accessible
        System.out.println("Department: " + department);       //  protected - accessible
        System.out.println("Salary: $" + getSalary());         //  private via getter
        System.out.println("Team Size: " + teamSize);
    }
}

// Define  a class to simulate a company system
public class CompanySystem  
{
    public static void main(String... args) 
    {
        Employee e1 = new Employee(101, "Finance", 55000.0);
        System.out.println("Employee Info:");
        e1.displayEmployeeInfo();

        System.out.println("\nManager Info:");
        Manager m1 = new Manager(202, "IT", 90000.0, 8);
        m1.displayManagerInfo();

        // Update salary
        m1.setSalary(95000.0);
        System.out.println("\nAfter Salary Update:");
        System.out.println("Updated Salary: $" + m1.getSalary());
    }
}