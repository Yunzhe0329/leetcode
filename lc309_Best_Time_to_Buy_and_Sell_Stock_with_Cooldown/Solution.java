package lc309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

// LeetCode 309. Best Time to Buy and Sell Stock with Cooldown
class Solution {
    public int maxProfit(int[] prices) {
        // state1 -> hold stock -> dp[i][0]
        // state2 -> sold stock -> dp[i][1]
        // state3 -> reset -> dp[i][2]
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            int price = prices[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - price);
            dp[i][1] = dp[i-1][0] + price
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }

        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
