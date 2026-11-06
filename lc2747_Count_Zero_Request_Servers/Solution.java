package lc2747_Count_Zero_Request_Servers;

import java.util.*;

// LeetCode 2747. Count Zero Request Servers
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[] result = new int[m];
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int[][] q_intervals = new int[m][2];
        for (int i = 0; i < m; i++) {
            q_intervals[i][0] = queries[i];
            q_intervals[i][1] = i;
        }
        Arrays.sort(q_intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int left = 0, right = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int[] interval : q_intervals) {
            int end = interval[0];
            while (right < logs.length && logs[right][1] <= end) {
                mp.put(logs[right][0], mp.getOrDefault(logs[right][0], 0) + 1);
                right++;
            }

            while (left < right && logs[left][1] < end - x) {
                mp.put(logs[left][0], mp.get(logs[left][0]) - 1);
                if (mp.get(logs[left][0]) == 0) {
                    mp.remove(logs[left][0]);
                }
                left++;
            }

            result[interval[1]] = n - mp.size();
        }

        return result;
    }
}
