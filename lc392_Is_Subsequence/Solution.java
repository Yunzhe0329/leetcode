package lc392_Is_Subsequence;

import java.util.*;

class Solution {
    public boolean isSubsequence(String s, String t) {
        // two-pointers(more efficient way : O(n))
        // int rs = 0;
        // int rt = 0;

        // while(rs < s.length() && rt < t.length()){
        // if(t.charAt(rt) == s.charAt(rs)){
        // rs++;
        // }
        // rt++;
        // }

        // return rs == s.length();

        // follow-up : if an input is really big(10 ^ 9)
        // 簡而言之，大量查詢需求，用雙指標找個東西都要掃描整個陣列，查表會是比較合適的方式
        // 這個方法並非有效率，只是順應情境設計與改良
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            // 紀錄 c 在 t 出現的位置
            map.get(c).add(i);
        }

        // s 是 t 的子序列，掃描過 s (順序不能變 s = ace, t = abcde 不能是 evacd)
        // 對 c 在 t 中的位置list做 BS，找第一個 >= next 的位置，O(log|t|)
        // next：t 中下一個可以使用的位置
        int next = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> list = map.get(c);
                int pos = binarySearch(next, list);
                if (pos == -1) {
                    return false;
                }
                next = pos + 1;
            } else {
                return false;
            }
        }

        return true;
    }

    private int binarySearch(int target, List<Integer> list) {
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