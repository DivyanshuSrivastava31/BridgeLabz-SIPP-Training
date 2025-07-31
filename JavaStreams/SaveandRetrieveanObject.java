import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class must implement Serializable to be written to an ObjectStream
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for version control

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + String.format("%.2f", salary);
    }
}

public class EmployeeSerialization {

    private static final String FILE_NAME = "employees.ser"; // File to store serialized employee data

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.println("--- Employee Data Management ---");

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Save Employees to File");
            System.out.println("3. Load Employees from File");
            System.out.println("4. Display Current Employees in Memory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addEmployee(scanner, employees);
                    break;
                case 2:
                    saveEmployees(employees);
                    break;
                case 3:
                    employees = loadEmployees(); // Load replaces the current list in memory
                    if (employees.isEmpty()) {
                        System.out.println("No employees loaded or file was empty.");
                    } else {
                        System.out.println("Employees loaded successfully.");
                        displayEmployees(employees);
                    }
                    break;
                case 4:
                    displayEmployees(employees);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee(Scanner scanner, List<Employee> employees) {
        System.out.print("Enter Employee ID: ");
        int id = 0;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a number.");
            return;
        }

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = 0.0;
        try {
            salary = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Salary. Please enter a number.");
            return;
        }

        employees.add(new Employee(id, name, department, salary));
        System.out.println("Employee added successfully!");
    }

    private static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employee data serialized and saved to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving employees: " + e.getMessage());
        }
    }

    private static List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No employee data file found: " + FILE_NAME);
            return employees; // Return empty list
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            // Read the object as a List and cast it
            Object obj = ois.readObject();
            if (obj instanceof List) {
                employees = (List<Employee>) obj;
            } else {
                System.err.println("Error: Data in file is not a list of employees.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. " + e.getMessage()); // Should be caught by file.exists() check
        } catch (IOException e) {
            System.err.println("Error reading employees from file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Employee class not found. This might happen if the class definition changed after serialization. " + e.getMessage());
        }
        return employees;
    }

    private static void displayEmployees(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("\n--- Current Employees ---");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("-------------------------");
    }
}