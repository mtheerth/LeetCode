class Solution {
    public int myAtoi(String s) {
       if (s == null || s.isEmpty()) return 0;

        int i = 0, n = s.length(), sign = 1, result = 0;
        
        // Step 1: Ignore leading whitespaces
        while (i < n && s.charAt(i) == ' ') i++;

        // Step 2: Check for '+' or '-'
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits and check for overflow
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow before adding digit
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
