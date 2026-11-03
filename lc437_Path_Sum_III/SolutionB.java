package lc437_Path_Sum_III;

import java.util.*;

class SolutionB {
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
    long prefixSum = 0;
    Map<Long, Integer> mp = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        mp.put(0L, 1);
        dfs(root, targetSum);
        return result;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        prefixSum += node.val;
        result += mp.getOrDefault(prefixSum - target, 0);
        mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);

        dfs(node.left, target);
        dfs(node.right, target);

        mp.put(prefixSum, mp.get(prefixSum) - 1);
        prefixSum -= node.val;
    }

}