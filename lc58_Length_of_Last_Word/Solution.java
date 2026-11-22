package lc58_Length_of_Last_Word;

// LeetCode 58. Length of Last Word
class Solution {
    public int lengthOfLastWord(String s) {
        int r = s.length() - 1;
        int length = 0;
        while (r >= 0 && s.charAt(r) == ' ') {
            r--;
        }
        while (r >= 0 && s.charAt(r) != ' ') {
            length++;
            r--;
        }
        return length;
    }
}
