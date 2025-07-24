import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordFrequencies = new HashMap<>();

        // Normalize the text: convert to lowercase and remove punctuation
        String cleanedText = text.toLowerCase().replaceAll("[^a-zA-Z\\s]", "");

        // Split the text into words
        String[] words = cleanedText.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequencies;
    }

    public static Map<String, Integer> countWordFrequencyFromFile(String filePath) throws FileNotFoundException {
        StringBuilder textBuilder = new StringBuilder();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            textBuilder.append(scanner.nextLine()).append(" ");
        }
        scanner.close();

        return countWordFrequency(textBuilder.toString());
    }

    public static void main(String[] args) {
        // Example with a string
        String inputText = "Hello world, hello Java!";
        Map<String, Integer> result1 = countWordFrequency(inputText);
        System.out.println("Input: \"" + inputText + "\" → Output: " + result1);

        // Example with a file (create a dummy file for testing)
        // You would need to create a file named "sample.txt" in your project directory
        // with content like: "This is a sample text. This text is for testing."
        try {
            // Uncomment and use this if you have a file
            // Map<String, Integer> result2 = countWordFrequencyFromFile("sample.txt");
            // System.out.println("File Word Frequencies: " + result2);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}