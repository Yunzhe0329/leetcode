package lc1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length;

class Solution {

    public int maxVowels(String s, int k) {
        // k == subarrays length, find the maximum vowels in any substring of s with
        // length k.
        int n = s.length();
        int curr = 0;
        // init the window (first substring)
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                curr++;
            }
        }

        int result = curr;
        // move to right, pop left, and count the vowels in current window
        for (int i = k; i < n; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                curr++;
            }
            if (isVowel(s.charAt(i - k))) {
                curr--;
            }
            if (curr > result) {
                result = curr;
            }
        }

        return result;

    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    void main() {
        String s1 = "abciiidef";
        int k1 = 3;
        IO.println(maxVowels(s1, k1));
    }
}