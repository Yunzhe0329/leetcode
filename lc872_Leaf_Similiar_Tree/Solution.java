package lc872_Leaf_Similiar_Tree;

import java.util.*;

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        dfs(root1, r1);
        dfs(root2, r2);

        return r1.equals(r2);
    }

    private void dfs(TreeNode node, List<Integer> leafs) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leafs.add(node.val);
            return;
        }

        dfs(node.left, leafs);
        dfs(node.right, leafs);

    }
}