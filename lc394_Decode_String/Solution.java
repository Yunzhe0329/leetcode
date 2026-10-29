package lc394_Decode_String;

import java.util.*;

class Solution {

    public String decodeString(String s) {
        Stack<Integer> kStack = new Stack<>();
        Stack<String> strs = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                kStack.push(k);
                strs.push(sb.toString());
                sb = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeat = kStack.pop();
                StringBuilder tmp = new StringBuilder(strs.pop());
                for (int i = 0; i < repeat; i++) {
                    tmp.append(sb);
                }
                sb = tmp;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    void main() {
        String s = "2[abc]3[cd]ef";
        IO.println(decodeString(s)); // expect [abcabccdcdcdef]
    }
}