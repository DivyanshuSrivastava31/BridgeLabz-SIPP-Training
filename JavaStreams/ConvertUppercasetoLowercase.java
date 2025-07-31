import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class UppercaseToLowercaseConverter {

    public static void main(String[] args) {
        String sourceFilePath = "source_text.txt"; // Replace with your source file path
        String destinationFilePath = "destination_lowercase.txt"; // Path for the new file

        // Create a dummy source file for testing if it doesn't exist
        createDummySourceFile(sourceFilePath);

        System.out.println("--- Converting Uppercase to Lowercase ---");

        // Use try-with-resources for automatic resource management
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath, StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine(); // Write a new line character after each line
            }

            System.out.println("Content from '" + sourceFilePath + "' converted to lowercase and written to '" + destinationFilePath + "'.");

        } catch (IOException e) {
            System.err.println("An error occurred during file operation: " + e.getMessage());
            // In a real application, you might log the exception or provide more specific error handling
        }
    }

    // Helper method to create a dummy source file for testing
    private static void createDummySourceFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Creating a dummy source file: " + filePath);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, StandardCharsets.UTF_8))) {
                writer.write("This is a Test File.\n");
                writer.write("HELLO WORLD!\n");
                writer.write("Java Programming Is FUN.\n");
                writer.write("Special Characters: éàçüñ\n"); // Example with special characters
                System.out.println("Dummy source file created successfully.");
            } catch (IOException e) {
                System.err.println("Error creating dummy source file: " + e.getMessage());
            }
        }
    }
}