package lc1137_N_th_Tribonacci_Number;

// LeetCode 1137. N-th Tribonacci Number
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] fib = new int[38];
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 3] + fib[i - 2] + fib[i - 1];
        }

        return fib[n];

    }
}
