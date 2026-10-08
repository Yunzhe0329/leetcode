package lc1021_Remove_Outermost_Parentheses;


class Solution{
    public String removeOuterParentheses(String s) {
        // String is already valid string
        // 優化後的解法，原先是用sliding window找primitive
        int balance = 0;
        StringBuilder result = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == '('){
                if(balance > 0) result.append(c);
                balance++;
            }else if(c == ')'){
                if(balance > 0) result.append(c);
                balance--;
                
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        // TCs
        String tc1 = "(()())(())";
        String tc2 = "(()())(())(()(()))";
        String tc3 = "()()";
        System.out.println(tc1);
        System.out.println(tc2);
        System.out.println(tc3);
        /*
        (()())(())
        (()())(())(()(()))
        ()()
        */
    }
}
