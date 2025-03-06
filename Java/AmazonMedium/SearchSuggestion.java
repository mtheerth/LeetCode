package my.test;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    // Find words with a given prefix
    public List<String> getSuggestions(String prefix) {
        List<String> result = new ArrayList<>();
        //result.subList(0, 0);
        TrieNode node = root;
        for (Character c : root.children.keySet()) {
        	System.out.println((char)c);
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
        	System.out.println(entry.getValue().children.keySet() + "" + entry.getKey());
        }
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return result; // No words with this prefix
            }
        }
        findWords(node, prefix, result);
        return result;
    }

    // Helper function to perform DFS and collect words from the Trie
    private void findWords(TrieNode node, String prefix, List<String> result) {
        if (node.isEndOfWord) {
            result.add(prefix);
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            findWords(entry.getValue(), prefix + entry.getKey(), result);
        }
    }
}



public class SearchSuggestion {
    public static void main(String[] args) {
        // Sample data: Words to be stored in the Trie
        String[] words = {"mabile", "mouse", "moneypot", "monitor", "mousepad", "bat"};
        
        // Create a Trie and insert words
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // Test prefix search (as user types input)
        String input = "b";  // Example input prefix
        List<String> suggestions = trie.getSuggestions(input);

        // Display suggestions
        System.out.println("Suggestions for '" + input + "': " + suggestions);
    }
}


