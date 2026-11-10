package lc3693_Climbing_Stairs_II;

import java.util.*;

// LeetCode 3693. Climbing Stairs II
class Solution {
    public int climbStairs(int n, int[] costs) {
        // costs is 1-indexed array
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int j = 1; j <= n; j++) {
            if (j - 1 >= 0) {
                dp[j] = Math.min(dp[j], dp[j - 1] + costs[j - 1] + 1);
            }
            if (j - 2 >= 0) {
                dp[j] = Math.min(dp[j], dp[j - 2] + costs[j - 1] + 4);
            }
            if (j - 3 >= 0) {
                dp[j] = Math.min(dp[j], dp[j - 3] + costs[j - 1] + 9);
            }
        }
        return dp[n];

    }
}
