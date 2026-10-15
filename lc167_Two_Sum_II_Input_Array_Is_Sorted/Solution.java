package lc167_Two_Sum_II_Input_Array_Is_Sorted;

import java.util.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // given 1-indexed array of
        // integers numbers that is already sorted in non-decreasing order.
        // there is exactly one solution.
        // You may not use the same element twice.
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[] { l + 1, r + 1 };
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[0];
    }

    void main() {
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;

        int[] nums2 = { 2, 3, 4 };
        int target2 = 6;

        int[] nums3 = { -1, 0 };
        int target3 = -1;

        IO.println(Arrays.toString(twoSum(nums1, target1)));
        IO.println(Arrays.toString(twoSum(nums2, target2)));
        IO.println(Arrays.toString(twoSum(nums3, target3)));
    }
}