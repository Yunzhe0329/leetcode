package lc3_Longest_Substring_Without_Repeating_Characters;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int l = 0;
        // Set<Character> seen = new HashSet<>();
        // s consists of English letters, digits, symbols and spaces.(128)
        int[] seen = new int[128];

        // for (int r = l; r < s.length(); r++) {
        // while (seen.contains(s.charAt(r))) {
        // seen.remove(s.charAt(l));
        // l++;
        // }
        // seen.add(s.charAt(r));
        // result = Math.max(result, r - l + 1);
        // }
        for (int r = l; r < s.length(); r++) {
            char c = s.charAt(r);
            while (seen[c] > 0) {
                seen[s.charAt(l)]--;
                l++;
            }
            seen[c]++;
            result = Math.max(result, r - l + 1);
        }

        return result;
    }

    void main() {
        String s1 = "pwwkew";
        IO.println(lengthOfLongestSubstring(s1));

        String s2 = "abcabcbb";
        IO.println(lengthOfLongestSubstring(s2));

        String s3 = "S";
        IO.println(lengthOfLongestSubstring(s3));
    }

}