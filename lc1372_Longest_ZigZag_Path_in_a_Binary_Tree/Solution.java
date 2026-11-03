// LeetCode 1372. Longest ZigZag Path in a Binary Tree

import java.util.Stack;

class Solution {
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

    int result = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);

        return result;
    }

    private void dfs(TreeNode node, boolean fromLeft, int count) {
        if (node == null) {
            return;
        }
        if (fromLeft) {
            dfs(node.right, false, count + 1);
            dfs(node.left, true, 1);
        } else {
            dfs(node.left, true, count + 1);
            dfs(node.right, false, 1);
        }
    }
}
