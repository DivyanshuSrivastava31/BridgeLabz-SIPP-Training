import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class EmployeeSalaryCategorization {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 70000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "Finance", 80000),
                new Employee("Eva", "IT", 75000)
        );

        Map<String, Double> avgSalaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println(avgSalaryByDept);
    }
}
