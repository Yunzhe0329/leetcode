// double stack solution
package lc678_Valid_Parenthesis_String;

import java.util.*;

public class Solution2 {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while (!left.isEmpty()) {
            if (star.isEmpty() || star.pop() < left.pop()) {
                return false;
            }
        }
        return true;
    }

}
