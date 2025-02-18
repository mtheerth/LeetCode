package my.test;

import java.util.*;

public class SearchSuggestionShort {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>();
        
        String searchWord = "mouse";
        words.add("mobile");
        words.add("mouse");
        words.add("moneypot");
        words.add("monitor");
        words.add("mousepad");
        StringBuilder st = new StringBuilder();
        for (int i =0 ; i < searchWord.length(); i++) {
        	st.append(searchWord.charAt(i));
            int count = 0;
            System.out.println("---------");
            for (String word : words) {
                if (word.startsWith(st.toString()) && count < 3) {
                    System.out.println(" Suggestion: " + word);
                    count++;
                }
            }
        }

    }
}

