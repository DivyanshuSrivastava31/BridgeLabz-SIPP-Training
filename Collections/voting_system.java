import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class VotingSystem {

    // HashMap to store votes: Candidate Name -> Number of Votes
    private Map<String, Integer> votesHashMap;

    // LinkedHashMap to maintain the order in which votes were cast (or candidates were first added)
    private Map<String, Integer> votesLinkedHashMap;

    // TreeMap to display results in sorted order (by candidate name, or by votes if a custom comparator is used)
    private TreeMap<String, Integer> votesTreeMap;

    public VotingSystem() {
        votesHashMap = new HashMap<>();
        votesLinkedHashMap = new LinkedHashMap<>();
        // TreeMap will sort by candidate name (String's natural order) by default.
        // If sorting by votes is desired, a custom Comparator would be needed.
        votesTreeMap = new TreeMap<>();
    }

    /**
     * Casts a vote for a given candidate.
     * Updates all three map types.
     *
     * @param candidateName The name of the candidate to vote for.
     */
    public void castVote(String candidateName) {
        // Update HashMap
        votesHashMap.put(candidateName, votesHashMap.getOrDefault(candidateName, 0) + 1);

        // Update LinkedHashMap
        // The put method will update the value for an existing key,
        // maintaining its original insertion order.
        votesLinkedHashMap.put(candidateName, votesLinkedHashMap.getOrDefault(candidateName, 0) + 1);

        // Update TreeMap
        votesTreeMap.put(candidateName, votesTreeMap.getOrDefault(candidateName, 0) + 1);
        System.out.println("Vote cast for: " + candidateName);
    }

    /**
     * Displays the current votes as stored in the HashMap.
     * This provides quick access but no guaranteed order.
     */
    public void displayVotesHashMap() {
        System.out.println("\n--- Current Votes (HashMap - No guaranteed order) ---");
        if (votesHashMap.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        for (Map.Entry<String, Integer> entry : votesHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    /**
     * Displays the current votes as stored in the LinkedHashMap.
     * This maintains the order in which candidates first received a vote.
     */
    public void displayVotesLinkedHashMap() {
        System.out.println("\n--- Current Votes (LinkedHashMap - Insertion Order) ---");
        if (votesLinkedHashMap.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        for (Map.Entry<String, Integer> entry : votesLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    /**
     * Displays the current election results in sorted order (by candidate name).
     * Uses the TreeMap for this purpose.
     */
    public void displayResultsSortedByCandidateName() {
        System.out.println("\n--- Election Results (TreeMap - Sorted by Candidate Name) ---");
        if (votesTreeMap.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        for (Map.Entry<String, Integer> entry : votesTreeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    /**
     * Displays the election results sorted by the number of votes (descending).
     * This involves converting to a List and sorting, as TreeMap sorts by key.
     */
    public void displayResultsSortedByVotes() {
        System.out.println("\n--- Election Results (Sorted by Votes - Descending) ---");
        if (votesHashMap.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }

        // Create a list of map entries from the HashMap (or any of them)
        List<Map.Entry<String, Integer>> sortedResults = new ArrayList<>(votesHashMap.entrySet());

        // Sort the list based on the values (number of votes) in descending order
        sortedResults.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : sortedResults) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }


    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Cast some votes
        system.castVote("Candidate A");
        system.castVote("Candidate B");
        system.castVote("Candidate A"); // Vote for A again
        system.castVote("Candidate C");
        system.castVote("Candidate B"); // Vote for B again
        system.castVote("Candidate A"); // Vote for A again

        // Display votes using different map types
        system.displayVotesHashMap();
        system.displayVotesLinkedHashMap();
        system.displayResultsSortedByCandidateName();
        system.displayResultsSortedByVotes(); // Display sorted by vote count
    }
}