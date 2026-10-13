package lc3727_Maximum_Alternating_Sum_of_Squares;

import java.util.*;

class Optimize {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] square = new long[n];
        long result = 0;

        for (int i = 0; i < n; i++) {
            square[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(square);

        // 原先的做法是用配對(l, r)去配對，odd length 再額外處理
        // 感覺可以切兩半，左半都是小的(要被扣掉的)、右半是大的(要加) => result += 大 - 小
        int pos = n / 2;
        for (int i = 0; i < n; i++) {
            result += (i < pos) ? -square[i] : square[i];
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