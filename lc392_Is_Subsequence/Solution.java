package lc392_Is_Subsequence;

import java.util.*;

class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mp.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mp.containsKey(c)) {
                List<Integer> list = mp.get(c);
                int pos = bs(idx, list);
                if (pos == -1) {
                    return false;
                }
                idx = pos + 1;
            } else {
                return false;
            }
        }
        return true;
    }

    private int bs(int target, List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l == list.size() ? -1 : list.get(l);
    }
}
