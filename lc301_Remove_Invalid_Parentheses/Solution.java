package lc301_Remove_Invalid_Parentheses;

import java.util.*;

class Solution{
    public List<String> removeInvalidParentheses(String s){
        // 1.刪除最小數量的 invalid "()"
        // 2.找出一個 result 滿足上面條件且 unique 的 string
        // 3.String s 裡面包含小寫英文字母,'(', ')'
        // 找組合目前直覺想到 backtrack
        // 但要滿足minimun removeal -> 先統計哪邊是invalid
        // s = "()())()"
        // open = 0, close = 1 -> 表示最多就刪除一個 ')'
        int left = 0;
        int right = 0;
        Set<String> result = new HashSet<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                left++;
            }else if(c == ')'){
                if(left > 0){
                    left--;
                }else{
                    right++;
                }
            }
        }
        backtrack(s, 0, left, right, 0, result, new StringBuilder());
        return new ArrayList<>(result);
    }
    
    private void backtrack(String s, int idx, int left, int right, int balance, Set<String> unique, StringBuilder valid){
        if(balance < 0) return;
        if(idx == s.length()){
            if(left == 0 && right == 0 && balance == 0){
                unique.add(valid.toString());
            }
            return;
        }
        // 每個字元 -> 選 or 刪除(left != 0 || right != 0)找出各種可能組合
        // "()()())" -> idx 5, 6 刪除哪個結果都會相同(只取一個)
        char c = s.charAt(idx);
        valid.append(c);
        if(c == '('){
            backtrack(s, idx+1, left, right, balance+1, unique, valid);
        }else if(c == ')'){
            backtrack(s, idx+1, left, right, balance-1, unique, valid);
        }else{
            backtrack(s, idx+1, left, right, balance, unique, valid);
        }
        valid.deleteCharAt(valid.length()-1);
        
        // 如果目前left 和 right 有刪除空間的狀況
        if(c == '(' && left > 0){
            backtrack(s, idx+1, left-1, right, balance, unique, valid);
        }
        if(c == ')' && right > 0){
            backtrack(s, idx+1, left, right-1, balance, unique, valid);
        }

    }
    


    public static void main(String[] args){
        Solution sol = new Solution();
        // TCs
        String tc1 = "((()))(";
        String tc2 = "()())()";
        String tc3 = "(a)())()";
        String tc4 = ")(";
        
        System.out.println(sol.removeInvalidParentheses(tc1));
        System.out.println(sol.removeInvalidParentheses(tc2));
        System.out.println(sol.removeInvalidParentheses(tc3));
        System.out.println(sol.removeInvalidParentheses(tc4));
        // TC outcome
        /*
        [((()))]
        [()()(), (())()]
        [(a)()(), (a())()]
        []
        */
    }
}
