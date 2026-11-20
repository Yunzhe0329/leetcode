package lc3041_Maximize_Consecutive_Elements_in_an_Array_After_Modification;

// LeetCode 3041. Maximize Consecutive Elements in an Array After Modification

import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = 1;
        int mx = nums[n - 1];
        // dp[i] = 用i作為結尾可得到多少長度
        int[] dp = new int[mx + 2];
        // 每個 element 可以有兩個 option: +1 or keep the same
        // 不 + 1 => dp[num] =  dp[num - 1] + 1
        // +1 =>  dp[num+1] = dp[num] + 1
        // 不能先更新 dp[num] (num 維持原樣)，後續再處理 dp[num+1] 會重複計算(error)
        for (int num : nums) {
            dp[num + 1] = dp[num] + 1;
            dp[num] = dp[num - 1] + 1;
            result = Math.max(result, Math.max(dp[num + 1], dp[num]));
        }
        return result;
    }
}
