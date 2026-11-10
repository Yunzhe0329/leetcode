package lc2951_Find_the_Peaks;

import java.util.ArrayList;
import java.util.List;

// LeetCode 2951. Find the Peaks
class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        int n = mountain.length - 1;
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                peaks.add(i);
            }
        }

        return peaks;
    }
}
