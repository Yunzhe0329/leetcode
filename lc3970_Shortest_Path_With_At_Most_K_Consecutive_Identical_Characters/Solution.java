package lc3970_Shortest_Path_With_At_Most_K_Consecutive_Identical_Characters;

import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // 先記錄每個 node 的 neighbor 是誰
        List<List<int[]>> adjacent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacent.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }
        // 紀錄每一個節點的distance
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] { 0, 0, 1 }); // idx 0: node, idx 1: distance, idx 2: consecutive counter

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int node = p[0];
            int distance = p[1];
            int cons = p[2];
            for (int[] adj : adjacent.get(node)) {
                if (labels.charAt(node) == labels.charAt(adj[0]) && cons == k) {
                    continue;
                }
                if (labels.charAt(node) == labels.charAt(adj[0])) {
                    if (dp[adj[0]][cons + 1] > distance + adj[1]) {
                        dp[adj[0]][cons + 1] = distance + adj[1];
                        pq.offer(new int[] { adj[0], dp[adj[0]][cons + 1], cons + 1 });
                    }
                } else if (dp[adj[0]][1] > distance + adj[1]) {
                    dp[adj[0]][1] = distance + adj[1];
                    pq.offer(new int[] { adj[0], dp[adj[0]][1], 1 });
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int col : dp[n - 1]) {
            if (col < result) {
                result = col;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}