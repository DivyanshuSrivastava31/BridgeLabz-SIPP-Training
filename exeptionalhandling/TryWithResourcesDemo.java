// Problem 5: Try-with-resources
import java.io.*;

public class TryWithResourcesDemo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            String firstLine = reader.readLine();
            System.out.println("First line: " + firstLine);
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}