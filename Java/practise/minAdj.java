package my.test;

public class minAdj {
    public static int minSwaps(String s) {
        int redCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') redCount++;
        }
        
        int left = 0, right = s.length() - 1;
        int result = 0;
        
        while (left < right) {
            if (s.charAt(left) == 'R' && s.charAt(right) == 'R') {
                redCount -= 2;
                result += right - left - 1 - redCount;
                left++;
                right--;
            } else if (s.charAt(left) != 'R') {
                left++;
            } else {
                right--;
            }
        }
        
        return result > 1_000_000_000 ? -1 : result;
    }
    
    public static void main(String args[]) {
    	String s = "WRWRWRWR";
    	System.out.println(minSwaps(s));
    }
}

