package lc1657_Determine_if_Two_Strings_Are_Close;

import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            counter1[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            counter2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((counter1[i] != 0 && counter2[i] == 0) ||
                    (counter1[i] == 0 && counter2[i] != 0)) {
                return false;
            }
        }

        Arrays.sort(counter1);
        Arrays.sort(counter2);

        for (int i = 0; i < 26; i++) {
            if (counter1[i] != counter2[i]) {
                return false;
            }
        }
        return true;
    }
}