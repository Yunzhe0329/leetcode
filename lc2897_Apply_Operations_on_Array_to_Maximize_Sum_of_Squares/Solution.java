package lc2897_Apply_Operations_on_Array_to_Maximize_Sum_of_Squares;

import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1000000007;
        int[] bits = new int[32];
        long result = 0;
        // 統計整個 List 每個位元數量
        // 每次選k個，都選最大，就是用統計出來的數量去湊出要選的數字(必定是當下最大)
        for (int x : nums) {
            for (int i = 0; i < 31; i++) {
                if ((x & (1 << i)) != 0) {
                    bits[i]++;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            long num = 0;
            for (int j = 0; j < 31; j++) {
                if (bits[j] > 0) {
                    num = (num | (1L << j));
                    bits[j]--;
                }
            }
            result = (result + num * num) % MOD;
        }

        return (int) result;
    }

    void main() {
        // Solution sol = new Solution();
        List<Integer> num1 = List.of(2, 6, 5, 8);
        IO.println(maxSum(num1, 2));
    }
}