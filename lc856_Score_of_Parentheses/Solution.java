package lc856_Score_of_Parentheses;
import java.util.*;
class Solution{
    public int scoreOfParentheses(String s){
        int score = 0;
        // 用 stack 紀錄在 位置 i 目前的分數是多少
        Stack<Integer> stk = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                stk.push(score);
                score = 0;
            }else{
                // 遇到')' 就是計算分數，
                score = stk.pop() + Math.max(score*2, 1);
            }
        }
        return score;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        // tc1
        String s1 = "()"; // 1
        // tc2
        String s2 = "(((())))"; // 8
        // tc3
        String s3 = "()()"; // 2

        System.out.println(sol.scoreOfParentheses(s1));
        System.out.println(sol.scoreOfParentheses(s2));
        System.out.println(sol.scoreOfParentheses(s3));
        
    }
}