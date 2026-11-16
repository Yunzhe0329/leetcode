package lc2243_Calculate_Digit_Sum_of_a_String;

// LeetCode 2243. Calculate Digit Sum of a String
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                for (int j = i; j < i + k && j < s.length(); j++) {
                    sum += (int) s.charAt(j) - '0';
                }
                sb.append(sum);
            }
            s = sb.toString();
        }
        return s;

    }

}
