package lc2124_Check_if_All_As_Appears_Before_All_Bs;

// LeetCode 2124. Check if All As Appears Before All Bs
class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        boolean flag = false;
        for (char c : s.toCharArray()) {
            if (c == 'a' && flag) {
                return false;
            }
            if (c == 'b') {
                flag = true;
            }
        }
        return true;
    }
}
