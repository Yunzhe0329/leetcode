package lc994_Rotting_Oranges;

import java.util.*;

// LeetCode 994. Rotting Oranges
class Solution {
    private final static int[][] diretions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        if (q.isEmpty()) {
            return -1;
        }
        int time = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                for (int[] dir : diretions) {
                    int nr = pos[0] + dir[0];
                    int nc = pos[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;

    }
}
