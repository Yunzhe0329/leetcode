package lc2352_Equal_Row_and_Column_Pairs;

import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int result = 0;
        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < n; j++) {
                key.append(grid[i][j]);
                key.append(',');
            }
            String k = key.toString();
            mp.put(k, mp.getOrDefault(k, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < n; j++) {
                key.append(grid[j][i]);
                key.append(',');
            }
            String k = key.toString();
            if (mp.containsKey(k)) {
                result += mp.get(k);
            }
        }

        return result;

    }

    void main() {
        int[][] grid1 = {
                { 3, 2, 1 },
                { 1, 7, 6 },
                { 2, 7, 7 },
        };

        IO.println(equalPairs(grid1)); // expect : 1
    }
}