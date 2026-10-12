package lc217_Contains_Duplicate;

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    void main() {
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 1, 1, 3, 2, 4 };
        IO.println(containsDuplicate(nums1)); // false
        IO.println(containsDuplicate(nums2)); // true
    }
}