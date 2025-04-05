class Solution {
    public String intToRoman(int num) {
        // Define arrays for Roman numeral characters and their corresponding values.
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
      
        // Initialize a StringBuilder to build the Roman numeral string.
        StringBuilder romanString = new StringBuilder();
      
        // Iterate over the Roman numerals and values to construct the Roman numeral.
        for (int i = 0; i < romanNumerals.length; i++) {
            while (num >= values[i]) { // While the number is greater than the current value
                num -= values[i]; // Subtract the value from the number
                romanString.append(romanNumerals[i]); // Append the corresponding Roman numeral to the string
            }
        }

        // Return the constructed Roman numeral string.
        return romanString.toString();
    }
}
