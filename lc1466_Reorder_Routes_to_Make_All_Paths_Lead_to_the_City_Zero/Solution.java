package lc1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero;

// LeetCode 1466. Reorder Routes to Make All Paths Lead to the City Zero
import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connetions) {
        // 先建立一張 adjacent 的表去紀錄 neighbors
        // connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
        // adj = [[1, -4], [-0,3], [3], [-1, -2], [0, 5], [-4]]
        // 用正負號作為標記，讓有向圖轉成無向圖去處理
        // 正數代表我可以從該node走到target node -> 需要被 reorder 的 edge -> changed++
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }
        for (int i = 0; i < connetions.length; i++) {
            adjacent.get(connetions[i][0]).add(connetions[i][1]);
            adjacent.get(connetions[i][1]).add(-connetions[i][0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        int changed = 0;
        while (!q.isEmpty()) {
            int currNode = q.poll();
            for (int adj : adjacent.get(currNode)) {
                if (!visited[Math.abs(adj)]) {
                    q.offer(Math.abs(adj));
                    visited[Math.abs(adj)] = true;
                    if (adj > 0) {
                        changed++;
                    }
                }
            }
        }
        return changed;
    }
}
