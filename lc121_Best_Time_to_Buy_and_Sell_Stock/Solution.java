package lc121_Best_Time_to_Buy_and_Sell_Stock;

// LeetCode 121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int minCost = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minCost);
            minCost = Math.min(minCost, price);
        }
        return maxProfit;
    }
}
