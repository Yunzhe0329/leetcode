package lc242_Valid_Anagram;

class Solution {
    /*
     * 
     * An anagram is a word or phrase formed by rearranging
     * the letters of a different word or phrase,
     * using all the original letters exactly once.
     * 
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int n : counter) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

    void main() {
        String s1 = "rabbit";
        String t1 = "aribtb";
        IO.println(isAnagram(s1, t1)); // true

        String s2 = "abs";
        String t2 = "acs";
        IO.println(isAnagram(s2, t2)); // false
    }
}