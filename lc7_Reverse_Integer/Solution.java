package lc7_Reverse_Integer;

class Solution {
    // -2^31 <= x <= 2^31 - 1
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + digit;
            x /= 10;
        }
        return result;
    }

    void main() {
        int x1 = 123;
        IO.println(reverse(x1));
    }
}