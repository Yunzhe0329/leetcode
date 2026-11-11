package lc17_Letter_Combinations_of_a_Phone_Number;

import java.util.*;

// LeetCode 17. Letter Combinations of a Phone Number
class Solution {
    private Map<Character, String> mp = new HashMap<>();
    {
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int idx, StringBuilder comb, List<String> list) {
        if (idx == digits.length()) {
            list.add(new String(comb));
            return;
        }
        String letter = mp.get(digits.charAt(idx));

        for (char c : letter.toCharArray()) {
            comb.append(c);
            backtrack(digits, idx + 1, comb, list);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
