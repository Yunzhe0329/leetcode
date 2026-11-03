import java.util.*;

class SolutionDFS {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int[] sum = new int[10001];
    int maxDepth = 1;

    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 1; i <= maxDepth; i++) {
            if (sum[i] > max) {
                max = sum[i];
                result = i;
            }
        }
        return result;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        sum[depth] += node.val;
        if (depth > maxDepth) {
            maxDepth = depth;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}