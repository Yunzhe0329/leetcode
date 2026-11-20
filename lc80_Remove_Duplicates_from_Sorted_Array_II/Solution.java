package lc80_Remove_Duplicates_from_Sorted_Array_II;

// LeetCode 80. Remove Duplicates from Sorted Array II
import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (idx < 2 || nums[i] != nums[idx - 2]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
