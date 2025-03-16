public class SequenceCount {

    public static int countSequence(int[] sequence, int[] array) {
        int seqLength = sequence.length;
        int arrLength = array.length;

        // Create a DP array where dp[i][j] represents the number of ways to match
        // the first i elements of the sequence with the first j elements of the array.
        int[][] dp = new int[seqLength + 1][arrLength + 1];

        // Initialize the DP array: an empty sequence can be matched in one way.
        for (int j = 0; j <= arrLength; j++) {
            dp[0][j] = 1;
        }

        // Fill the DP array
        for (int i = 1; i <= seqLength; i++) {
            for (int j = 1; j <= arrLength; j++) {
                // If the current elements match, add the ways to match the previous elements
                if (sequence[i - 1] == array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    // If they don't match, carry over the ways from the previous element in the array
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // The answer will be in dp[seqLength][arrLength]
        return dp[seqLength][arrLength];
    }

    public static void main(String[] args) {
        int[] sequence = {4, 6, 2};
        int[] array = {3, 4, 4, 6, 7, 8, 2, 6, 9, 2};

        int count = countSequence(sequence, array);
        System.out.println("Count of sequence: " + count);  // Output: 3
    }
}
