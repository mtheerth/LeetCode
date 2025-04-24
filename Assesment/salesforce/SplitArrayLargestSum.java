public class Solution {

    // Method to compute the minimum sum of maximums for k subarrays
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        int INF = Integer.MAX_VALUE;

        // Initialize the dp array with INF
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = INF;
            }
        }

        dp[0][0] = 0;

        // DP state transitions
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                int maxInSubarray = 0;
                for (int p = i - 1; p >= j - 1; p--) {
                    maxInSubarray = Math.max(maxInSubarray, nums[p]);
                    if (dp[p][j - 1] != INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + maxInSubarray);
                    }
                }
            }
        }

        return dp[n][k];
    }

    // Main method with Case 0
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Case 0
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        int result = sol.splitArray(nums, k);

        System.out.println("Case 0:");
        System.out.println("Output: " + result);
        System.out.println("Expected: 6");
    }
}

