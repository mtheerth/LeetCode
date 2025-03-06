package practise.leetcode;


public class IntToStringMoney {
    
    // Define word representations for numbers
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
                                                 "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
                                                 "Seventeen", "Eighteen", "Nineteen"};
    
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        String result = "";
        int i = 0;
        
        // Process each group of 3 digits (thousands, millions, etc.)
        while (num > 0) {
        	System.out.println(num % 1000);
        	if (num % 1000 != 0) {
                result = helper(num % 1000) + THOUSANDS[i] + " " + result;
            }
        	System.out.println( num / 1000);
            num /= 1000;
            
            i++;
        }
        
        // Remove the extra space at the end
        return result.trim();
    }
    
    // Helper function to process numbers less than 1000
    private String helper(int num) {
        if (num == 0) return "";
        if (num < 20) return LESS_THAN_20[num] + " ";
        if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
        return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
    
    public static void main(String[] args) {
    	IntToStringMoney solution = new IntToStringMoney();
        System.out.println(solution.numberToWords(1234567)); // Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
       // System.out.println(solution.numberToWords(0)); // Output: "Zero"
        //System.out.println(solution.numberToWords(123)); // Output: "One Hundred Twenty Three"
    }
}

