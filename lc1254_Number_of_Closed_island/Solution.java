package lc1254_Number_of_Closed_island;

class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        // for boundary check
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                dfs(grid, i, 0);
            }
            if (grid[i][n - 1] == 0) {
                dfs(grid, i, n - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                dfs(grid, 0, i);
            }
            if (grid[m - 1][i] == 0) {
                dfs(grid, m - 1, i);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;

    }

    private void dfs(int[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 1) {
            return;
        }
        grid[row][col] = 1;
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);

    }
}