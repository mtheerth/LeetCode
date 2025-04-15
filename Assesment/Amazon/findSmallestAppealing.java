/*Given org_code = 1234, where org_code / n = 4, and k = 2, the task is to find the smallest new_code such that it is greater than or equal to org_code and satisfies the attractiveness condition, meaning digits repeat every ( k ) positions.
First, take the first ( k ) digits from org_code (12) and repeat them to form the candidate new_code = 1212. Since 1212 is smaller than 1234, we increment the first two digits, resulting in 13, and repeat it to get new_code = 1313.

This new code is attractive because ( b[0] = b[2] = 1 ) and ( b[1] = b[3] = 3 ), and it also satisfies ( org_code <= new_code ) (as 1313 >= 1234).
Thus, 1313 is the required new_code.

*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
      Solution f = new Solution();
    System.out.println(  f.findSmallestAppealing("1234",2));
  }
}
public class Solution {
    public static String findSmallestAppealing(String old_code, int k) {
        int n = old_code.length();
        String base = old_code.substring(0, k);
        String candidate = generateCandidate(base, n);
        
        if (candidate.compareTo(old_code) >= 0) {
            return candidate;
        } else {
            // Increment the base
            String newBase = incrementString(base);
            if (newBase.length() > base.length()) {
                // New base has more digits than k, which means it's 10...0 (k zeros)
                // But the base must be of length k. So newBase is 1 followed by k-1 zeros.
                newBase = "1";
                for (int i = 1; i < k; i++) {
                    newBase += "0";
                }
            }
            candidate = generateCandidate(newBase, n);
            return candidate;
        }
    }
    
    private static String generateCandidate(String base, int n) {
        int k = base.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(base.charAt(i % k));
        }
        return sb.toString();
    }
    
    private static String incrementString(String s) {
        char[] chars = s.toCharArray();
        int carry = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (carry == 0) break;
            int digit = chars[i] - '0' + carry;
            if (digit >= 10) {
                digit -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            chars[i] = (char) (digit + '0');
        }
        if (carry == 1) {
            return "1" + new String(chars);
        } else {
            return new String(chars);
        }
    }
}
