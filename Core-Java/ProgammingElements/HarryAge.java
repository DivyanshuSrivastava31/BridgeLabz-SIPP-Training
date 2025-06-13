//Computing Harry's Age from birth and current year
public class HarryAge {
    public static void main(String[] args) {
        // Declare and initialize the birth year of Harry
        int birthYear = 2000;

        // Declare and initialize the current year
        int currentYear = 2024;

        // Calculate age by subtracting birth year from current year
        int age = currentYear - birthYear;

        // Print the result
        System.out.println("Harry's age in " + currentYear + " is " + age);
    }
}
