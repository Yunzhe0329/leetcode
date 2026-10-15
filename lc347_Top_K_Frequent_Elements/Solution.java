package lc347_Top_K_Frequent_Elements;

import java.util.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // nums = [1,1,1,2,2,3], k = 2
        Map<Integer, Integer> freq = new HashMap<>();
        // 用 maxheap，頻率高的會在上方
        PriorityQueue<int[]> h = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // freq : {1:3, 2:2, 3:1}
        for (Map.Entry<Integer, Integer> pair : freq.entrySet()) {
            h.offer(new int[] { pair.getValue(), pair.getKey() });
            if (h.size() > k) {
                h.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = h.poll()[1];
        }
        return result;
    }

    void main() {
        int[] nums1 = { 1, 1, 1, 2, 2, 3 };
        int k1 = 2;
        IO.println(Arrays.toString(topKFrequent(nums1, k1)));

        int[] nums2 = { 1 };
        int k2 = 1;
        IO.println(Arrays.toString(topKFrequent(nums2, k2)));

        int[] nums3 = { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 };
        int k3 = 2;
        IO.println(Arrays.toString(topKFrequent(nums3, k3)));
    }
}