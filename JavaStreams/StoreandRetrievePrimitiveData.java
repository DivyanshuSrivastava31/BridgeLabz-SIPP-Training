import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StudentDataStream {

    private static final String FILE_NAME = "student_details.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Data Management (Binary File) ---");
            System.out.println("1. Add Student Details and Save");
            System.out.println("2. Load and Display Student Details");
            System.out.println("3. Exit");
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
                    addAndSaveStudentDetails(scanner);
                    break;
                case 2:
                    loadAndDisplayStudentDetails();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAndSaveStudentDetails(Scanner scanner) {
        System.out.print("Enter Roll Number: ");
        int rollNumber = -1;
        try {
            rollNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Roll Number. Please enter an integer.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = -1.0;
        try {
            gpa = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid GPA. Please enter a number (e.g., 3.5).");
            return;
        }

        // Use try-with-resources to ensure streams are closed automatically
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) { // 'true' for append mode
            dos.writeInt(rollNumber);
            dos.writeUTF(name); // writeUTF for String
            dos.writeDouble(gpa);
            System.out.println("Student details added and saved to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving student details: " + e.getMessage());
        }
    }

    private static void loadAndDisplayStudentDetails() {
        System.out.println("\n--- Loading Student Details ---");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                try {
                    int rollNumber = dis.readInt();
                    String name = dis.readUTF();
                    double gpa = dis.readDouble();

                    System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + String.format("%.2f", gpa));
                } catch (IOException e) {
                    // Reached end of file or corrupted data
                    System.out.println("End of file or error reading a record.");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading student details: " + e.getMessage());
            if (e instanceof java.io.FileNotFoundException) {
                System.out.println("File '" + FILE_NAME + "' not found. Add some student details first.");
            }
        }
        System.out.println("-------------------------------");
    }
}