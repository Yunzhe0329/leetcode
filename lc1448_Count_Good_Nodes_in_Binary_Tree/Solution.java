package lc1448_Count_Good_Nodes_in_Binary_Tree;

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

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int currMax) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val >= currMax) {
            count = 1;
        }
        currMax = Math.max(currMax, node.val);
        count += dfs(node.left, currMax);
        count += dfs(node.right, currMax);
        return count;
    }

}