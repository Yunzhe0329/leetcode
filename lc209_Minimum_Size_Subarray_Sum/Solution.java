package lc209_Minimum_Size_Subarray_Sum;

// LeetCode 209. Minimum Size Subarray Sum
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int result = Integer.MAX_VALUE;
        while (r < nums.length) {
            int sum = 0;
            sum += nums[r++];

            while (sum >= target) {
                result = Math.min(result, r - l);
                sum -= nums[l++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
