package lc3619_Count_Islands_With_Total_Value_Divisible_by_K;

class Solution {

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    long sum = dfs(grid, m, n, i, j);
                    if (sum % k == 0) {
                        result++;
                    }
                }
            }
        }
        return result;

    }

    private long dfs(int[][] grid, int m, int n, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
            return 0;
        }

        long sum = grid[row][col];
        grid[row][col] = 0;
        sum += dfs(grid, m, n, row + 1, col);
        sum += dfs(grid, m, n, row - 1, col);
        sum += dfs(grid, m, n, row, col + 1);
        sum += dfs(grid, m, n, row, col - 1);
        return sum;

    }

    void main() {
        int[][] grid = {
                { 0, 2, 1, 0, 0 },
                { 0, 5, 0, 0, 5 },
                { 0, 0, 1, 0, 0 },
                { 0, 1, 4, 7, 0 },
                { 0, 2, 0, 0, 8 }
        };
        int k = 5;

        IO.println(countIslands(grid, k));
    }
}