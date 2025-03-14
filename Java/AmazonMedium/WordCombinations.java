import java.util.*;

public class WordCombinationsLinkedList {
    public static void main(String[] args) {
        // List of words that can be broken down into smaller words
        List<String> words = Arrays.asList("high", "way", "highway", "highw", "ay");

        // Find word combinations and print the result
        Map<String, List<List<String>>> result = findCombinations(words);
        
        // Display the output
        for (Map.Entry<String, List<List<String>>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    /**
     * Finds all possible ways to split each word in the list into valid smaller words.
     * @param words List of words to process.
     * @return Map where each key is a word, and the value is a list of valid combinations.
     */
    public static Map<String, List<List<String>>> findCombinations(List<String> words) {
        Set<String> wordSet = new HashSet<>(words); // Store words in a Set for quick lookups
        Map<String, List<List<String>>> result = new HashMap<>();

        for (String word : words) {
            List<List<String>> combinations = new ArrayList<>();
            findSplits(word, wordSet, new LinkedList<>(), combinations, 0);
            if (!combinations.isEmpty()) {
                result.put(word, combinations);
            }
        }
        return result;
    }

    /**
     * Recursively finds all valid ways to split a word using a backtracking approach.
     * @param word The full word being checked.
     * @param wordSet Set of words for quick lookup.
     * @param current A LinkedList to store the current path of words.
     * @param combinations A list to store all valid combinations.
     * @param start The current starting index of the substring.
     */
    private static void findSplits(String word, Set<String> wordSet, LinkedList<String> current, List<List<String>> combinations, int start) {
        // Base case: if we reached the end and have more than one word, add to combinations
        if (start == word.length()) {
            if (current.size() > 1) {
                combinations.add(new ArrayList<>(current));
            }
            return;
        }

        // Try all possible substrings starting from 'start'
         
        for (int i = start + 1; i <= word.length(); i++) {
            String part = word.substring(start, i);
            if (wordSet.contains(part)) {
                current.addLast(part); // Add the found part to the current list
                findSplits(word, wordSet, current, combinations, i); // Recursive call
                current.removeLast(); // Backtrack to explore other possibilities
       }
        }
    }
}

