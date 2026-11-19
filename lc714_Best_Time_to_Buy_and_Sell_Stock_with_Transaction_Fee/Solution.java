package lc714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

// LeetCode 714. Best Time to Buy and Sell Stock with Transaction Fee
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // int[] buy = new int[n];
        // int[] sell = new int[n];
        // buy[0] = -prices[0];
        // for (int i = 1; i < n; i++) {
        //     buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
        //     sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1] - fee);
        // }
        // return sell[n - 1];
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < n; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, prices[i] + buy - fee);
        }
        return sell;
    }
}
