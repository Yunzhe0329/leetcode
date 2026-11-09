package lc2542_Maximum_Subsequence_Score;

import java.util.*;

// LeetCode 2542. Maximum Subsequence Score
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        long result = 0;
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long curr = 0;
        for (int[] p : pairs) {
            pq.offer(p[0]);
            curr += p[0];

            if (pq.size() > k) {
                curr -= pq.poll();
            }

            if (pq.size() == k) {
                result = Math.max(result, curr * p[1]);
            }
        }
        return result;

    }
}
