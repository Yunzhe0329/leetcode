package lc2089_Find_Target_Indices_After_Sorting_Array;

import java.util.*;

class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {
        // Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int lessTarget = 0;
        int equalTarget = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                lessTarget++;
            } else if (nums[i] == target) {
                equalTarget++;
            }
        }
        if (equalTarget == 0) {
            return result;
        }

        while (equalTarget != 0) {
            result.add(lessTarget);
            lessTarget++;
            equalTarget--;
        }

        return result;
    }

    void main() {
        int[] nums = { 1, 2, 5, 2, 3 };
        IO.println(targetIndices(nums, 2));
        IO.println(targetIndices(nums, 3));
        IO.println(targetIndices(nums, 5));
    }
}