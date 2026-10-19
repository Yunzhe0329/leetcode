package lc560_Subarray_Sum_Equals_K;

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sum = new HashMap<>();
        sum.put(0, 1); // sum = 0. means its a null sub array
        int total = 0;
        int result = 0;
        for (int num : nums) {
            total += num;
            int prefix_sum = total - k;
            if (sum.containsKey(prefix_sum)) {
                result += sum.get(prefix_sum);
            }
            sum.put(total, sum.getOrDefault(total, 0) + 1);
        }

        return result;
    }

    void main() {
        int[] nums1 = { 1, 1, 1 };
        IO.println(subarraySum(nums1, 2));
    }
}