import java.util.*;

public class PhoneNumberWordsGenerator {

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    private static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isWord = true;
        }
    }

    private final Map<Character, String> digitMap;
    private final Trie trie;

    public PhoneNumberWordsGenerator(Set<String> dictionary) {
        // Initialize digit-letter mappings
        digitMap = new HashMap<>();
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");

        // Build Trie from dictionary
        trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word.toLowerCase());
        }
    }

    public List<String> generateWords(String phoneNumber) {
        String digits = cleanPhoneNumber(phoneNumber);
        List<String> results = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), results, trie.root);
        return results;
    }

    private String cleanPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceAll("[^0-9]", "");
    }

    private void backtrack(String digits, int index, StringBuilder current, 
                          List<String> results, TrieNode node) {
        if (index == digits.length()) {
            if (node.isWord) {
                results.add(current.toString());
            }
            return;
        }

        char digit = digits.charAt(index);
        if (digitMap.containsKey(digit)) {
            String letters = digitMap.get(digit);
            for (char letter : letters.toCharArray()) {
                TrieNode nextNode = node.children.get(letter);
                if (nextNode != null) {
                    current.append(letter);
                    backtrack(digits, index + 1, current, results, nextNode);
                    current.deleteCharAt(current.length() - 1);
                }
            }
        } else {
            // Skip 0/1 and proceed to next digit
            backtrack(digits, index + 1, current, results, node);
        }
    }

    public static void main(String[] args) {
        // Example usage
        Set<String> dictionary = new HashSet<>(Arrays.asList("tree", "used", "cat", "dog"));
        PhoneNumberWordsGenerator generator = new PhoneNumberWordsGenerator(dictionary);
        
        List<String> words = generator.generateWords("8733"); // Corresponds to "tree"
        System.out.println(words); // Output: [tree]
    }
}

