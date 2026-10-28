package lc3882_Minimum_XOR_Path_in_a_Grid;

class Solution {

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 0 <= grid[i][j] <= 1023​
        // possible xor value will less than 1024
        boolean[][][] dp = new boolean[m][n][1024];
        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    for (int k = 0; k < 1024; k++) {
                        if (dp[i - 1][j][k]) {
                            dp[i][j][grid[i][j] ^ k] = true;
                        }
                    }
                }

                if (j > 0) {
                    for (int k = 0; k < 1024; k++) {
                        if (dp[i][j - 1][k]) {
                            dp[i][j][grid[i][j] ^ k] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 1024; i++) {
            if (dp[m - 1][n - 1][i]) {
                return i;
            }
        }

        return 0;
    }

}