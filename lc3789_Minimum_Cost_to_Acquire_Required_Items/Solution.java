package lc3789_Minimum_Cost_to_Acquire_Required_Items;

// LeetCode 3789. Minimum Cost to Acquire Required Items
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (need1 == 0 && need2 == 0) {
            return 0;
        }
        long c1 = cost1, c2 = cost2, cboth = costBoth;
        long n1 = need1, n2 = need2;
        long pairs = Math.min(n1, n2);
        long costPairs = Math.min(cboth, c1 + c2) * pairs;
        long rem1 = n1 - pairs;
        long rem2 = n2 - pairs;
        long remain = rem1 * Math.min(c1, cboth) + rem2 * Math.min(c2, cboth);

        return costPairs + remain;
    }
}
