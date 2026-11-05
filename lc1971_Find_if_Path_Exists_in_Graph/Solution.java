package lc1971_Find_if_Path_Exists_in_Graph;

import java.util.*;

// LeetCode 1971. Find if Path Exists in Graph
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Set<Integer> visited = new HashSet<>();
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = buildGraph(n, edges);
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == destination) {
                return true;
            }
            List<Integer> neighbors = graph.get(node);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        return false;

    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);

        }
        return graph;
    }

}
