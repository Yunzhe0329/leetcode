package lc392_Is_Subsequence;

import java.util.*;

class SolutionB {
    public boolean isSubsequence(String s, String t) {
        int ptrS = 0;
        int ptrT = 0;

        while (ptrS < s.length() && ptrT < t.length()) {
            if (t.charAt(ptrT) == s.charAt(ptrS)) {
                ptrS++;
            }
            ptrT++;
        }

        return ptrS == s.length();
    }
}
