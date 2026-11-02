package lc113_Path_Sum_II;

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), root, targetSum);
        return result;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> path, TreeNode node, int target) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && node.val == target) {
            list.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;

        } else {
            backtrack(list, path, node.left, target - node.val);
            backtrack(list, path, node.right, target - node.val);
        }
        path.remove(path.size() - 1);
    }

}