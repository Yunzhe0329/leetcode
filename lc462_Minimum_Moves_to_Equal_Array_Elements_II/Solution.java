package lc462_Minimum_Moves_to_Equal_Array_Elements_II;

import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = 0;
        if (n % 2 == 0) {
            median = ((nums[n / 2 - 1] + nums[nums.length / 2]) / 2);
        } else {
            median = nums[nums.length / 2];
        }
        int result = 0;
        for (int num : nums) {
            result += Math.abs(num - median);
        }
        return result;
    }

    void main() {
        int[] nums = { 1, 10, 2, 9 };
        IO.println(minMoves2(nums));
    }
}