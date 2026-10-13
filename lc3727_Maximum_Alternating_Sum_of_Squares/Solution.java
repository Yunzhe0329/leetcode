package lc3727_Maximum_Alternating_Sum_of_Squares;

import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long result = 0;
        // long[] square = new long[n];
        // for (int i = 0; i < n; i++) {
        // square[i] = (long) nums[i] * nums[i];
        // }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        int l = 0;
        int r = n - 1;
        if (n % 2 != 0) {
            int mid = (r + l) / 2;
            result += nums[mid];
        }
        while (l <= r) {
            result += (long) nums[r] - nums[l];
            l++;
            r--;
        }
        return result;
    }

    void main() {
        int[] nums1 = { 1, 2, 3 };
        IO.println(maxAlternatingSum(nums1));

        int[] nums2 = { 1, -1, 2, -2, 3, -3 };
        IO.println(maxAlternatingSum(nums2));
    }
}