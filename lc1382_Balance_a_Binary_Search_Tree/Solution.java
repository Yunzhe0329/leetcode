package lc1382_Balance_a_Binary_Search_Tree;

import java.util.*;
import lc1382_Balance_a_Binary_Search_Tree.*;

class Solution {

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        inorder(root, result);
        return rebuild(result, 0, result.size() - 1);
    }

    // 把 BST 做 inorder 變成一個 sorted array
    public void inorder(TreeNode root, List<TreeNode> arr) {
        if (root == null)
            return;

        inorder(root.left, arr);
        arr.add(root);
        inorder(root.right, arr);
    }

    // Balance BST -> divide & concur
    private TreeNode rebuild(List<TreeNode> arr, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = arr.get(mid);
        root.left = rebuild(arr, left, mid - 1);
        root.right = rebuild(arr, mid + 1, right);
        return root;
    }
}