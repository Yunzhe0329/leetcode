// greedy solution
package lc678_Valid_Parenthesis_String;

class Solution {
    public boolean checkValidString(String s) {
        // * can be '(' or ')' if needed. or it can be empty string
        // check if a string is valid
        int max_pair = 0;
        int min_pair = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                max_pair++;
                min_pair++;
            } else if (c == ')') {
                max_pair--;
                min_pair--;
            } else {
                max_pair++;
                min_pair--;
            }
            if (max_pair < 0)
                return false;
            if (min_pair < 0)
                min_pair = 0;
        }
        // 最小需要滿足的數量不為0 -> Invalid
        return min_pair == 0;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // tc1
        String s1 = "(*)()";
        System.out.println(sol.checkValidString(s1));// true

    }
}