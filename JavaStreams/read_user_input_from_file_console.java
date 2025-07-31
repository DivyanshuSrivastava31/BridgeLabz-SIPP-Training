import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputToFile {

    public static void main(String[] args) {
        String fileName = "user_info.txt"; // The file to save user information

        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new FileWriter(fileName);

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine(); // Read as String, can parse to int if needed for other operations

            System.out.print("Enter your favorite programming language: ");
            String favLanguage = reader.readLine();

            // Write the information to the file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + favLanguage + "\n");

            System.out.println("\nUser information successfully saved to " + fileName);

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Ensure streams are closed
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}