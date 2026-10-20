package lc1071_Greatest_Common_Divisor_of_Strings;

class Solution {
    public String gcdOfStrings(String s, String t) {
        // t divides s
        // s = t + t + t +... + t
        if (!(s + t).equals(t + s)) {
            return "";
        }
        int result = gcd(s.length(), t.length());
        return s.substring(0, result);

    }

    private int gcd(int s, int t) {
        int largest = Math.min(s, t);
        for (int i = largest; i > 0; i--) {
            if (s % i == 0 && t % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
