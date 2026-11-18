package lc452_Minimum_Number_of_Arrows_to_Burst_Balloons;

// LeetCode 452. Minimum Number of Arrows to Burst Balloons
import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // 有 overlapping -> 1 arrow 即可
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int result = 1;
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // non-overlapping means new start -> need more arrows
            if (points[i][0] > prevEnd) {
                result++;
                prevEnd = points[i][1];
            }
        }
        return result;
    }
}
