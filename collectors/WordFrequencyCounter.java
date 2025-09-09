import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String paragraph = "hello world hello java world java stream hello";

        Map<String, Long> wordCount =
                Stream.of(paragraph.split("\\s+"))
                        .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println(wordCount);
    }
}
