package lc14_Longest_Common_Prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        int prefix_length = prefix.length();

        for (String s : strs) {
            while (prefix_length > s.length() || !prefix.equals(s.substring(0, prefix_length))) {
                prefix_length--;
                if (prefix_length == 0) {
                    return "";
                }
                prefix = prefix.substring(0, prefix_length);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] strs1 = new String[] { "flower", "flow", "flight" };
        System.out.println(sol.longestCommonPrefix(strs1)); // "fl"

        String[] strs2 = new String[] { "dog", "racecar", "car" };
        System.out.println(sol.longestCommonPrefix(strs2)); // ""

    }
}