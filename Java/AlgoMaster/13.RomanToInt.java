class Solution {
    public int romanToInt(String s) {
        // A string representing the Roman numerals in increasing order.
        String romanSymbols = "IVXLCDM";
        // Corresponding values of Roman numerals as per the order in the string.
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        // Map to store Roman numerals and their values for quick access.
        Map<Character, Integer> numeralToValue = new HashMap<>();
      
        // Populate the map with symbol-value pairs.
        for (int i = 0; i < values.length; ++i) {
            numeralToValue.put(romanSymbols.charAt(i), values[i]);
        }
      
        // Length of the string containing the Roman numeral.
        int length = s.length();
        // Start with the value of the last symbol as there is nothing following it to compare.
        int totalValue = numeralToValue.get(s.charAt(length - 1));
      
        // Loop through the string in reverse order stopping before the first character.
        for (int i = 0; i < length - 1; ++i) {
            // Determine the sign based on whether the current symbol is less than the one following it.
            // This helps in applying the subtractive rule of Roman numerals.
            int sign = numeralToValue.get(s.charAt(i)) < numeralToValue.get(s.charAt(i + 1)) ? -1 : 1;
            // Add or subtract the value of the current symbol to the total value.
            totalValue += sign * numeralToValue.get(s.charAt(i));
        }
      
        // Return the computed total value as the integer value of the input Roman numeral.
        return totalValue;
    }
}
