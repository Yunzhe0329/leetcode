package lc921_Minimum_Add_to_Make_Parentheses_Valid;

class Solution{
    
    public int minAddToMakeValid(String s) {
        int open = 0;
        int result = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                open++;
            }else if(open == 0){
                result++;
            }else{
                open--;
            }
        }
        return result + open;
    }

    public static void main(String[] args){
        // tc1
        String s1 = "())";

        // tc2
        String s2 = "(((";

        Solution sol = new Solution();
        
        System.out.println(sol.minAddToMakeValid(s1)); // 1
        System.out.println(sol.minAddToMakeValid(s2)); // 3
    }
}