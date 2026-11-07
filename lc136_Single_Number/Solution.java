package lc136_Single_Number;

// LeetCode 136. Single Number
class Solution {
    public int singleNumber(int[] nums) {
        // XOR -> 1 ^ 1 = 0, 1 ^ 0 = 1
        // 0 ^ num = num
        // nums: [4,1,2,1,2]
        // -> 4 ^ 1 ^ 2 ^ 1 ^ 2
        // -> 4^(1^1)^(2^2) = 4 ^ 0 = 4(result)
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;

    }
}
