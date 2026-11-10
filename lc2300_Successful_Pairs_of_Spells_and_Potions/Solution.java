package lc2300_Successful_Pairs_of_Spells_and_Potions;

import java.util.*;

// LeetCode 2300. Successful Pairs of Spells and Potions
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] pair = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long k = (long) spell * potions[mid];
                if (k >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            pair[i] = m - left;
        }

        return pair;
    }
}