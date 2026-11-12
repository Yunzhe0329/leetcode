package lc3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray;

// LeetCode 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increase = 1;
        int decrease = 1;
        int result = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                increase++;
                decrease = 1;
            } else if (nums[i + 1] < nums[i]) {
                decrease++;
                increase = 1;
            } else {
                increase = 1;
                decrease = 1;
            }
            result = Math.max(result, Math.max(increase, decrease));
        }
        return result;

    }
}
