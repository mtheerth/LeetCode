class Solution {
    public int myAtoi(String s) {
        int mod = 1000000007;
        s = s.trim();
        boolean isNgative = false;
        if( s.charAt(0) == '-'){
            isNgative = true;
            s = s.substring(1);
        }
        int result = 0;
        for (int i=0; i< s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                int digit = s.charAt(i) - '0';
                if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10  && digit > Integer.MAX_VALUE % 10)) {
                return isNgative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
                result = (result *10 + digit) % mod;
            } else {
                break;
            }

        }
        return result;
    }
}
