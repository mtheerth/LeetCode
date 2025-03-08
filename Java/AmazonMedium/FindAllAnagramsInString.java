import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int lenS = s.length();
        int lenP = p.length();

        if (lenS < lenP) {
            return result;
        }

        // Frequency arrays for p and the current window in s
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Initialize the frequency array for p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Initialize the frequency array for the first window in s
        for (int i = 0; i < lenP; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // Compare the first window
        if (matches(pCount, sCount)) {
            result.add(0);
        }

        // Slide the window through s
        for (int i = lenP; i < lenS; i++) {
            // Remove the leftmost character of the previous window
            char leftChar = s.charAt(i - lenP);
            sCount[leftChar - 'a']--;

            // Add the new character to the window
            char rightChar = s.charAt(i);
            sCount[rightChar - 'a']++;

            // Compare the current window with pCount
            if (matches(pCount, sCount)) {
                result.add(i - lenP + 1);
            }
        }

        return result;
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAllAnagramsInString solution = new FindAllAnagramsInString();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result); // Output: [0, 6]
    }
}
