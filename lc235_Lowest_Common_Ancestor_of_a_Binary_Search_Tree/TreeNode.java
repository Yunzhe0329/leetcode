package lc235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

//Definition for a binary tree node.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // BST -> 左小右大的規則
        // 要找出 node p, node q 的 LCA(最低共同祖先)
        // 從 root 開始往下找
        // case 1 -> 往左走-> p, q 的 val 都比 root 小
        // case 2 -> 往右走-> p, q 的 val 都比 root 大
        // case 3 -> p, q 在一左一右、或是 p 或 q 本身就是 LCA
        TreeNode curr = root;

        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return null;
    }

}
