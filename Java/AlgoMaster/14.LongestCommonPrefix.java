class Solution {
    public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    
    for (int i = 0; i < strs[0].length(); i++) {
        char c = strs[0].charAt(i);
        // Check two conditions here: 
                // 1. If the current string is shorter than the current character index, or
                // 2. If the current character does not match the character in the first string.
                // In either case, that means we've found the end of the common prefix.
        for (int j = 1; j < strs.length; j++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c) {
                return strs[0].substring(0, i);
            }
        }
    }
     // If we manage to check all characters of the first string without finding a mismatch,
        // it means that the entire first string is a common prefix.
    return strs[0];
    }
}
