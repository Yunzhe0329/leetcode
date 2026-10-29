package lc2390_Removing_Stars_From_a_String;

import java.util.*;

public class Solution {
    public String removeStars(String s) {
        int n = s.length();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*' && !stk.isEmpty()) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        char[] result = new char[stk.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stk.pop();
        }

        return new String(result);

    }

    void main() {
        String s = "leet**cod*e";
        IO.println(removeStars(s));
    }
}
