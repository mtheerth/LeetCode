import java.util.ArrayList;
import java.util.List;

public class StringCombinations {
    public static List<String> generateCombinations(String str) {
        List<String> combinations = new ArrayList<>();
        generateCombinationsHelper("", str, combinations);
        return combinations;
    }

    private static void generateCombinationsHelper(String prefix, String remaining, List<String> combinations) {
        if (!prefix.isEmpty()) {
            combinations.add(prefix + (isPalindrome(prefix) ? " (Palindrome)" : ""));
        }
        
        for (int i = 0; i < remaining.length(); i++) {
            generateCombinationsHelper(prefix + remaining.charAt(i), remaining.substring(i + 1), combinations);
        }
    }

    private static boolean isPalindrome(String str) {
        if (str.length() < 2) return true;
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abcd";
        List<String> result = generateCombinations(input);
        for (String combination : result) {
            System.out.println(combination);
        }
    }
}

