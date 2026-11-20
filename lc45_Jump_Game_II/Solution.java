package lc45_Jump_Game_II;

// LeetCode 45. Jump Game II
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int result = 0;
        int maxReach = 0;
        int currEnd = 0;

        for (int i = 0; i < n; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currEnd) {
                result++;
                currEnd = maxReach;

                if (currEnd >= n - 1) {
                    break;
                }
            }
        }
        return result;
    }
}
