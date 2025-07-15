import java.io.*;

public class FileReadPerformance {

    public static void readWithFileReader(String filePath) {
        try (FileReader fr = new FileReader(filePath)) {
            long start = System.nanoTime();
            while (fr.read() != -1) {
                // Read character by character
            }
            long end = System.nanoTime();
            System.out.println("FileReader Time: " + (end - start) / 1_000_000.0 + " ms");
        } catch (IOException e) {
            System.out.println("FileReader error: " + e.getMessage());
        }
    }

    public static void readWithInputStreamReader(String filePath) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            long start = System.nanoTime();
            while (isr.read() != -1) {
                // Read character by character
            }
            long end = System.nanoTime();
            System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000.0 + " ms");
        } catch (IOException e) {
            System.out.println("InputStreamReader error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "testfile.txt"; // Replace with the actual file path

        System.out.println("Reading file: " + filePath);
        readWithFileReader(filePath);
        readWithInputStreamReader(filePath);
    }
}
