import java.io.*;
import java.util.*;

public class PerformanceComparison {

    public static void main(String[] args) {
        // Part 1: StringBuilder vs StringBuffer
        concatenateUsingStringBuilder();
        concatenateUsingStringBuffer();

        // Part 2: FileReader and InputStreamReader
        String filePath = "large_text_file.txt"; // Replace with your 100MB file path
        countWordsUsingFileReader(filePath);
        countWordsUsingInputStreamReader(filePath);
    }

    // 1. StringBuilder
    public static void concatenateUsingStringBuilder() {
        StringBuilder sb = new StringBuilder();
        String word = "hello";
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            sb.append(word);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time using StringBuilder: " + (endTime - startTime) + " ms");
    }

    // 2. StringBuffer
    public static void concatenateUsingStringBuffer() {
        StringBuffer sb = new StringBuffer();
        String word = "hello";
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            sb.append(word);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time using StringBuffer: " + (endTime - startTime) + " ms");
    }

    // 3. FileReader for word count
    public static void countWordsUsingFileReader(String filePath) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }

        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
            return;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("FileReader - Word Count: " + wordCount + ", Time: " + (endTime - startTime) + " ms");
    }

    // 4. InputStreamReader for word count
    public static void countWordsUsingInputStreamReader(String filePath) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }

        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
            return;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("InputStreamReader - Word Count: " + wordCount + ", Time: " + (endTime - startTime) + " ms");
    }
}
