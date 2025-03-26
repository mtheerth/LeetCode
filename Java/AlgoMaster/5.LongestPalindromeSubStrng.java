class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        // Base case: every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        /*
b	a	b	a	d
1	0	0	0	0
0	1	0	0	0
0	0	1	0	0
0	0	0	1	0
0	0	0	0	1
        */

        int mxLen = 1;  // To store the length of the longest palindrome found
        int start = 0;  // To store the start index of the longest palindrome

        // L is the length of the substring
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;     
                if (L == 2) { // if length of char is 2 then just compare char at 1 and j and make it true if they are same palindrome rule.
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else { // if len is more than 2 then curr char and previous char 
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                
                if (dp[i][j] && L > mxLen) {
                    mxLen = L;
                    start = i;
                }
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, start + mxLen);
    }
}

