import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeFileReader {

    public static void main(String[] args) {
        String filePath = "path/to/your/large/file.txt"; // !!! IMPORTANT: Replace with the actual path to your large file

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Reading file: " + filePath);
            String line;
            long linesProcessed = 0;

            while ((line = reader.readLine()) != null) {
                linesProcessed++;
                // Check if the line contains "error" (case-insensitive)
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Found error on line " + linesProcessed + ": " + line);
                }
            }
            System.out.println("\nFinished processing file. Total lines processed: " + linesProcessed);

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            System.err.println("Please ensure the file exists and the path is correct.");
        }
    }
}