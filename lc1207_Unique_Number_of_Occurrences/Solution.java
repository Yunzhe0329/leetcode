package lc1207_Unique_Number_of_Occurrences;

import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> freq = new HashSet<>();

        for (int val : mp.values()) {
            if (freq.contains(val)) {
                return false;
            }
            freq.add(val);
        }

        return true;
    }
}