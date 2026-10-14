package lc128_Longest_Consecutive_Sequence;

import java.util.*;

class Solution {

    public int longestConsecutive(int[] nums) {
        // nums[100,4,200,1,3,2]
        // longest consecutive elements sequence = 4
        // [1,2,3,4]
        int result = 0;
        Set<Integer> elements = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            elements.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int curr_len = 1;
            int val = nums[i];

            while (elements.contains(--val)) {
                curr_len++;
                elements.remove(val);
            }
            val = nums[i];
            while (elements.contains(++val)) {
                curr_len++;
                elements.remove(val);
            }

            result = Math.max(result, curr_len);
        }
        return result;
    }

    void main() {
        int[] nums1 = { 2, 20, 4, 10, 3, 4, 5 }; // expect 4
        IO.println(longestConsecutive(nums1));

        int[] nums2 = { 0, 3, 2, 5, 4, 6, 1, 1 }; // expect 7
        IO.println(longestConsecutive(nums2));
    }
}