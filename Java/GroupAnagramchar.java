package my.test;

import java.util.*;

public class GroupAnagramchar {
	  	    public static List<List<String>> groupAnagrams(String[] strs) {
	        // Map to hold groups of anagrams
	        Map<String, List<String>> map = new HashMap<>();
	        
	        for (String str : strs) {
	            // Create a key based on character frequencies
	            String key = getKey(str);
	            
	            // If the key already exists, add the string to the corresponding list
	            if (!map.containsKey(key)) {
	                map.put(key, new ArrayList<>());
	            }
	            map.get(key).add(str);
	        }
	        
	        // Return the list of values (grouped anagrams)
	        return new ArrayList<>(map.values());
	    }

	    private static String getKey(String str) {
	        // Initialize an array to store frequency of each character (assuming lowercase English letters)
	        int[] count = new int[26]; // For 'a' to 'z'
	        
	        // Count the frequency of each character in the string
	        for (char c : str.toCharArray()) {
	            count[c - 'a']++;
	        }
	        
	        // Build a string representing the frequency array (this will be the unique key for anagrams)
	        StringBuilder key = new StringBuilder();
	        for (int i = 0; i < 26; i++) {
	            if (count[i] > 0) {
	                key.append((char)(i + 'a')).append(count[i]);
	            }
	        }
	        
	        return key.toString();
	    }
	    
	    public static void main(String[] args) {
	        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
	        
	        List<List<String>> groupedAnagrams = groupAnagrams(strs);
	        
	        // Print the result
	        for (List<String> group : groupedAnagrams) {
	            System.out.println(group);
	        }
	    }

}

