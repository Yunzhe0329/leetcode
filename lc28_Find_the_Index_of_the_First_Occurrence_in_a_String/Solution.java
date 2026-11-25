// LeetCode 28. Find the Index of the First Occurrence in a String
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int strStr(String haystack, String needle){
        if(haystack.length() < needle.length()){
            return -1;
        }
        int m = haystack.length();
        int n = needle.length();
        for(int i = 0; i <= m - n; i++){
            if(haystack.substring(i, i + n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
