package lc129_Sum_Root_To_Leaf_Numbers;

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

class Solution {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path_sum) {
        if (root == null) {
            return 0;
        }
        path_sum = path_sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return path_sum;
        }

        return dfs(root.left, path_sum) + dfs(root.right, path_sum);
    }
}