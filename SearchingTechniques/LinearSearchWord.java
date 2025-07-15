public class LinearSearchWord {

    public static String searchSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            // Check if the word is present as a whole word using regex
            String pattern = "\\b" + word + "\\b";
            if (sentence.matches(".*" + pattern + ".*")) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog",
            "Java is a powerful programming language",
            "Linear search is simple but inefficient",
            "We are learning data structures"
        };

        String searchWord = "Java";

        String result = searchSentence(sentences, searchWord);
        System.out.println("Result: " + result);
    }
}
