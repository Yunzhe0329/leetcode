package lc3364_Minimum_Positive_Sum_Subarray;

import java.util.List;

// LeetCode 3364. Minimum Positive Sum Subarray
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int result = Integer.MAX_VALUE;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums.get(j);
                int length = j - i + 1;
                if (length >= l && length <= r && sum > 0) {
                    result = Math.min(result, sum);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }
}
