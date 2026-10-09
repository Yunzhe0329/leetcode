package lc1541_Minimum_Insertion_to_Balance_a_Parentheses_String;
class Optimize{
    public int minInsertions(String s){
        int left = 0;
        int result = 0;
        if(s == null || s.length() == 0) return result;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                left++;
            }else{
                if(left == 0){
                    if(i < s.length()-1 && s.charAt(i+1) == ')'){
                        i++;
                    }else{
                        result++;
                    }
                    result++;
                }else{
                    if(i < s.length()-1 && s.charAt(i+1) == ')'){
                        i++;
                    }else{
                        result++;
                    }
                    left--;
                }

            }
        }
        return result + (left * 2);
    }
    
    public static void main(String[] args){
        Optimize opt = new Optimize();
        // tcs
        String tc1 = ""; // expect 0
        String tc2 = "))("; // expect 3
        String tc3 = "(()))"; // expect 1
        String tc4 = "())"; // expect 0

        System.out.println(opt.minInsertions(tc1)); // 0
        System.out.println(opt.minInsertions(tc2)); // 3
        System.out.println(opt.minInsertions(tc3)); // 1
        System.out.println(opt.minInsertions(tc4)); // 0

    }
}