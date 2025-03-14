class Solution {
    public String longestPrefix(String s) {
         int n = s.length();
        int[] lps = new int[n]; // LPS array
        int len = 0; // Length of the previous longest prefix suffix

        // Compute the LPS array
        for (int i = 1; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Move back in the LPS array
                } else {
                    lps[i] = 0; // No match, set LPS to 0
                    i++;
                }
            }
        }

        // The longest happy prefix is the substring from 0 to lps[n-1]
        return s.substring(0, lps[n - 1]);
    }
}
