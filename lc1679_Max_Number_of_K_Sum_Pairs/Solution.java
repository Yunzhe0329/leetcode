package lc1679_Max_Number_of_K_Sum_Pairs;

import java.util.*;

class Solution {

    public int maxOperations(int[] nums, int k) {
        // Arrays.sort(nums);
        // int l = 0;
        // int r = nums.length - 1;
        // int operation = 0;

        // while (l < r) {
        // int sum = nums[l] + nums[r];
        // if (sum == k) {
        // operation++;
        // l++;
        // r--;
        // } else if (sum < k) {
        // l++;
        // } else {
        // r--;
        // }
        // }
        // return operation;

        Map<Integer, Integer> mp = new HashMap<>();
        int operation = 0;

        for (int num : nums) {
            int pair = k - num;
            if (mp.containsKey(pair) && mp.get(pair) > 0) {
                operation++;
                mp.put(pair, mp.get(pair) - 1);
            } else {
                mp.put(num, mp.getOrDefault(num, 0) + 1);
            }
        }
        return operation;
    }

    void main() {
        int[] nums1 = { 1, 2, 3, 4 };
        int k1 = 5;
        IO.println(maxOperations(nums1, k1));
    }
}