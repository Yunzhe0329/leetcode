package lc13_Roman_to_Integer;

import java.util.*;

// LeetCode 13. Roman to Integer

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        for (int i = 0; i < s.length() - 1; i++) {
            if (mp.get(s.charAt(i)) < mp.get(s.charAt(i + 1))) {
                result -= mp.get(s.charAt(i));
            } else {
                result += mp.get(s.charAt(i));
            }
        }
        return result + mp.get(s.charAt(s.length() - 1));
    }
}
