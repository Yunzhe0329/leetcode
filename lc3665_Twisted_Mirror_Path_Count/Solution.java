package lc3665_Twisted_Mirror_Path_Count;

import java.util.*;

class Solution {
    int[][][] dp;
    int MOD = 1000000007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // in each position, can choose go right or go down
        // dp[i][j][0] -> right
        // dp[i][j][1] -> down
        this.dp = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(grid, 0, 0, 0);

    }

    private int dfs(int[][] grid, int row, int col, int direction) {
        // direction == 0 -> right, direction == 1 -> go down
        // invalid path
        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }
        // valid path can go from top-left to bottom right
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        if (dp[row][col][direction] != -1) {
            return dp[row][col][direction];
        }

        if (grid[row][col] == 1) {
            if (direction == 0) {
                return dp[row][col][direction] = dfs(grid, row + 1, col, 1);
            } else {
                return dp[row][col][direction] = dfs(grid, row, col + 1, 0);
            }
        }
        long goRight = dfs(grid, row, col + 1, 0);
        long goDown = dfs(grid, row + 1, col, 1);

        return dp[row][col][direction] = (int) ((goRight + goDown) % MOD);

    }

    void main() {
        int[][] grid = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 0, 0 },
        };
        IO.println(uniquePaths(grid)); // expect = 5
    }
}