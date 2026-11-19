package lc2567_Minimum_Score_by_Changing_Two_Elements;

import java.util.*;

// LeetCode 2567. Minimum Score by Changing Two Elements
class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int case1 = nums[n - 1] - nums[2];
        int case2 = nums[n - 2] - nums[1];
        int case3 = nums[n - 3] - nums[0];

        return Math.min(case1, Math.min(case2, case3));
    }
}
