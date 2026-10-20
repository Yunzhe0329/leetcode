package lc98_Validate_BST;

//import java.util.*;

class Solution {

    public boolean isValidBST(TreeNode root) {
        // -2^31 <= Node.val <= 2^31 - 1
        // List<Integer> sorted = new ArrayList<>();
        // inorder(root, sorted);
        // int prev = sorted.get(0);

        // for (int i = 1; i < sorted.size(); i++) {
        // int curr = sorted.get(i);
        // if (curr <= prev) {
        // return false;
        // }
        // prev = curr;
        // }
        // return true;
        return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean inorder(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }

        return inorder(node.left, min, node.val) && inorder(node.right, node.val, max);
    }

    // private void inorder(TreeNode node, List<Integer> nums) {
    // if (node == null) {
    // return;
    // }
    // inorder(node.left, nums);
    // nums.add(node.val);
    // inorder(node.right, nums);
    // }

}

class TreeNode {
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
