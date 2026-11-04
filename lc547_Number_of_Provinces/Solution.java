package lc547_Number_of_Provinces;

// LeetCode 547. Number of Provinces
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                result++;
            }
        }

        return result;
    }

    private void dfs(int[][] nodes, int[] visited, int idx) {
        for (int j = 0; j < nodes.length; j++) {
            if (nodes[idx][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                // recursion to find connected nodes
                dfs(nodes, visited, j);
            }
        }
    }
}
