package lc14_Longest_Common_Prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int prefixLength = prefix.length();

        for (int i = 1; i < strs.length; i++) {
            String next = strs[i];
            while (prefixLength > next.length()
                    || !prefix.equals(next.substring(0, prefixLength))) {
                prefixLength--;
                if (prefixLength == 0) {
                    return "";
                }
                prefix = prefix.substring(0, prefixLength);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] strs1 = new String[] {"flower", "flow", "flight"};
        System.out.println(sol.longestCommonPrefix(strs1)); // "fl"

        String[] strs2 = new String[] {"dog", "racecar", "car"};
        System.out.println(sol.longestCommonPrefix(strs2)); // ""
    }
}
