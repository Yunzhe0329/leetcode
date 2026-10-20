package lc105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.*;

class Solution {
    Map<Integer, Integer> inorder_pos;
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder 順著下去可以知道 root 是誰，但無法區分左右
        // Inorder 可以做到這件事，判斷 left subtree, right subtree
        inorder_pos = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorder_pos.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1);

    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        int val = preorder[idx++];
        TreeNode root = new TreeNode(val);

        int mid = inorder_pos.get(val);
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }

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
