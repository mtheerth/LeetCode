public class ReverseBinaryString {
    public static int reverseBinaryString(String s) {
        String target = new StringBuilder(s).reverse().toString();
        int maxPrefix = 0;
        int left = 0;
        
        for (char c : s.toCharArray()) {
            if (left < target.length() && c == target.charAt(left)) {
                left++;
            }
        }
        return s.length() - left;
    }

    public static void main(String[] args) {
        String s = "00110101";
        System.out.println(reverseBinaryString(s)); // Output: 3
    }
}

