package lc345_Reverse_Vowels_of_a_String;

import java.util.*;

class Solution {
    static final Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] str = s.toCharArray();
        while (l < r) {
            while (l < r && !vowels.contains(str[l])) {
                l++;
            }
            while (l < r && !vowels.contains(str[r])) {
                r--;
            }
            char tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;

        }
        return new String(str);

    }

    void main() {
        String s1 = "IceCreAm";
        IO.println(reverseVowels(s1));

        String s2 = "leetcode";
        IO.println(reverseVowels(s2));

    }
}