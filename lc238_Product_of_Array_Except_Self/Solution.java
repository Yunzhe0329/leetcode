package lc238_Product_of_Array_Except_Self;

import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        /*
         * solution 1 需要用到額外的空間
         * int[] prefix = new int[n];
         * int[] postfix = new int[n];
         * prefix[0] = 1;
         * postfix[n - 1] = 1;
         * 
         * for (int i = 1; i < n; i++) {
         * prefix[i] = prefix[i - 1] * nums[i - 1];
         * }
         * 
         * for (int i = n - 2; i >= 0; i--) {
         * postfix[i] = postfix[i + 1] * nums[i + 1];
         * }
         * 
         * int[] result = new int[n];
         * for (int i = 0; i < n; i++) {
         * result[i] = prefix[i] * postfix[i];
         * }
         */
        int[] result = new int[n];
        result[0] = 1;
        // count for prefix
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }

    void main() {
        int[] nums1 = new int[] { 1, 2, 3, 4 };
        IO.println(Arrays.toString(productExceptSelf(nums1))); // [24, 12, 8, 6]

        int[] nums2 = new int[] { -1, 1, 0, -3, 3 };
        IO.println(Arrays.toString(productExceptSelf(nums2))); // [0, 0, 9, 0, 0]
    }
}