package lc1926_Nearest_Exit_from_Entrance_in_Maze;

import java.util.*;

// LeetCode 1926. Nearest Exit from Entrance in Maze
class Solution {
    static final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int result = 0;
        while (!q.isEmpty()) {
            result++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                int row = pos[0];
                int col = pos[1];
                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || maze[nr][nc] == '+') {
                        continue;
                    }
                    if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1) {
                        return result;
                    }
                    q.offer(new int[] { nr, nc });
                    maze[nr][nc] = '+';
                }
            }
        }
        return -1;
    }
}
