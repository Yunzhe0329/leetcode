package lc3619_Count_Islands_With_Total_Value_Divisible_by_K;

import java.util.*;

// BFS Solution

class SolutionB {

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = 0;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] { i, j });
                    sum += grid[i][j];
                    grid[i][j] = 0;

                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        int row = pos[0];
                        int col = pos[1];

                        for (int[] dir : directions) {
                            int nr = row + dir[0];
                            int nc = col + dir[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0) {
                                sum += grid[nr][nc];
                                q.offer(new int[] { nr, nc });
                                grid[nr][nc] = 0;
                            }
                        }
                    }

                    if (sum % k == 0) {
                        result++;
                    }

                }
            }
        }

        return result;
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