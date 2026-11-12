package lc435_Non_overlapping_Intervals;

import java.util.*;

// LeetCode 435. Non-overlapping Intervals
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int n = intervals.length;
        int prev = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[prev][1] <= intervals[i][0]) {
                prev = i;
                count++;
            }
        }
        return n - count;
    }
}
