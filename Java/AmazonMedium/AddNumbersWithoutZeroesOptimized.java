public class AddNumbersWithoutZeroesOptimized {
    public static void main(String[] args) {
        String num1 = "1050";
        String num2 = "2003";

        // Step 1: Compute the numeric value of each string after removing zeroes
        int number1 = computeNumberWithoutZeroes(num1);
        int number2 = computeNumberWithoutZeroes(num2);

        // Step 2: Add the two numbers
        int result = number1 + number2;

        // Step 3: Print the result
        System.out.println("Result: " + result); // Output: Result: 218
    }

    // Helper method to compute the numeric value of a string after removing zeroes
    private static int computeNumberWithoutZeroes(String num) {
        int result = 0;
        for (char c : num.toCharArray()) {
            if (c != '0') { // Skip zeroes
                result = result * 10 + (c - '0'); // Construct the number
            }
        }
        return result;
    }
}
