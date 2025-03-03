public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) return 0;

    int n = prices.length;
    int[][] dp = new int[n][2];

    // Base cases
    dp[0][0] = 0;           // No stock on day 0
    dp[0][1] = -prices[0];  // Buy stock on day 0

    for (int i = 1; i < n; i++) {
        // No stock on day i: either sold on day i or skipped
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        // Hold stock on day i: either bought on day i or held from day i-1
        dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
    }

    return dp[n - 1][0];
}
