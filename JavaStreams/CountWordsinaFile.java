import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    public static void main(String[] args) {
        String filePath = "path/to/your/text/file.txt"; // !!! IMPORTANT: Replace with the actual path to your file

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Map<String, Integer> wordCounts = new HashMap<>();
            String line;

            // Regex to find words (alphanumeric characters)
            Pattern pattern = Pattern.compile("\\b\\w+\\b");

            while ((line = reader.readLine()) != null) {
                // Convert line to lowercase to ensure case-insensitive counting
                String lowerCaseLine = line.toLowerCase();
                Matcher matcher = pattern.matcher(lowerCaseLine);

                while (matcher.find()) {
                    String word = matcher.group();
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }

            System.out.println("Total unique words found: " + wordCounts.size());

            // Sort words by frequency in descending order
            wordCounts.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(5) // Get the top 5
                    .forEach(entry -> System.out.println("Word: '" + entry.getKey() + "' -> Count: " + entry.getValue()));

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            System.err.println("Please ensure the file exists and the path is correct.");
        }
    }
}