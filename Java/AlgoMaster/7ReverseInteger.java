class Solution {
    public int reverse(int x) {
        // Initialize answer to hold the reversed number
        int reversedNumber = 0;
      
        // Loop until x becomes 0
        while (x != 0) {
            // Check for overflow/underflow condition, return 0 if violated
            // Integer.MIN_VALUE is -2^31 and Integer.MAX_VALUE is 2^31 - 1
            if (reversedNumber < Integer.MIN_VALUE / 10 || reversedNumber > Integer.MAX_VALUE / 10) {
                return 0;
            }
          
            // Add the last digit of x to reversedNumber
            reversedNumber = reversedNumber * 10 + x % 10;
          
            // Remove the last digit from x
            x /= 10;
        }
      
        // Return the reversed number
        return reversedNumber;
    }
}
