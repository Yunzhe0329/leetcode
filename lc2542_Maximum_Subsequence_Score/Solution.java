package lc2542_Maximum_Subsequence_Score;

import java.util.*;

// LeetCode 2542. Maximum Subsequence Score
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = nums1[i];
            pair[i][1] = nums2[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(a[1], b[1]));

        long result = 0;
        long curr = 0;

        for (int i = 0; i < n; i++) {
            curr += pair[i][0];
            minHeap.offer(pair[i][0]);
        }

    }
}
