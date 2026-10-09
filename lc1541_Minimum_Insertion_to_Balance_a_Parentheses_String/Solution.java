package lc1541_Minimum_Insertion_to_Balance_a_Parentheses_String;

import java.util.Stack;


class Solution{
    public int minInsertions(String s){
        // one '(' paring with two ')' -> valid
        // '(' must must go before two "consecutive" of ')' 要是連續的右括號 -> valid
        // You can choose to insert '(' or ')' to make s become valid
        // return the minimun insertion to make s valid
        Stack<Character> stk = new Stack<>();
        int result = 0;
        if(s == null || s.length() == 0) return result;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stk.push(c);
            }else{
                if(stk.isEmpty()){
                    if(i < s.length() - 1 && s.charAt(i+1) == ')'){
                        i++;
                    }else{
                        result++; // insert ')' to become a valid pair "))"
                    }
                    result++; // consecutive "))" need a '('
                }else{
                    if(i < s.length()-1 && s.charAt(i+1) == ')'){
                        i++;
                    }else{
                        result++;
                    }
                    stk.pop();
                }
            }
        }
        // 最後一個字元如果是'(' -> 會需要做兩個 insert
        return result + stk.size()*2;

        
    }
    
    public static void main(String[] args){
        Solution sol = new Solution();
        // tcs
        String tc1 = ""; // expect 0
        String tc2 = "))("; // expect 3
        String tc3 = "(()))"; // expect 1
        String tc4 = "())"; // expect 0

        System.out.println(sol.minInsertions(tc1)); // 0
        System.out.println(sol.minInsertions(tc2)); // 3
        System.out.println(sol.minInsertions(tc3)); // 1
        System.out.println(sol.minInsertions(tc4)); // 0

    }
}