package lc3551_Minimum_Swaps_to_Sort_by_Digit_Sum;

import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        // 用 pair 紀錄當下 index 中的數值以及其 digit sum
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            int sum = calculateDigitSum(nums[i]);
            pair[i][0] = sum;
            pair[i][1] = nums[i];
        }

        // 會需要 swap 的情況:
        // index i 的 sum of digit 比較大要換
        // 相同 sum 的情況之下，num 比較大也要換
        Arrays.sort(pair, (a, b) -> {
            // sum 不同，則 sum 小的往前排
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            // sum 相同，則 num 小的往前排
            return Integer.compare(a[1], b[1]);
        });

        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = pair[i][1];
        }
        // 紀錄原本元素所在的位置
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < n; i++) {
            record.put(nums[i], i);
        }

        int swap = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) {
                // 模擬 swap 的情況，模擬後 swap+1
                int swap_idx = record.get(sorted[i]);
                int tmp = nums[i];
                nums[i] = nums[swap_idx];
                nums[swap_idx] = tmp;
                record.put(nums[swap_idx], swap_idx);
                record.put(nums[i], i);
                swap++;
            }
        }
        return swap;

    }

    private int calculateDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    void main() {
        int[] nums1 = { 37, 100 };

        int[] nums2 = { 22, 14, 33, 7 };

        IO.println(minSwaps(nums1));
        IO.println(minSwaps(nums2));
    }
}