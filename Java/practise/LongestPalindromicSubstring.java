public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0;  // To keep track of the start and end indices of the longest palindrome found
        
        for (int i = 0; i < s.length(); i++) {
            // Expand around the center for both odd and even length palindromes
            int len1 = expandAroundCenter(s, i, i);  // Odd length
            int len2 = expandAroundCenter(s, i, i + 1);  // Even length
            
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                // Update start and end indices of the longest palindrome
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    // Helper function to expand around the center and return the length of the palindrome
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }
}

