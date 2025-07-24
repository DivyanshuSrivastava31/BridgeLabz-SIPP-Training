import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Assuming Employee and Department classes are defined as follows:
class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}

class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (" + department.getName() + ")";
    }
}

public class ObjectGrouper {

    public static Map<Department, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> groupedEmployees = new HashMap<>();

        for (Employee employee : employees) {
            Department department = employee.getDepartment();
            groupedEmployees.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);
        }
        return groupedEmployees;
    }

    public static void main(String[] args) {
        Department hr = new Department("HR");
        Department it = new Department("IT");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", hr));
        employees.add(new Employee("Bob", it));
        employees.add(new