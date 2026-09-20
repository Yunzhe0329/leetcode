/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // 用 level 去看，找到目前最右的節點就是 right side view
        // level處理 0 -> 1 -> 2...
        // 在每個 level 去找最右
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }
    private void dfs(TreeNode node, List<Integer> list, int depth){
        if(node == null) return;
        if(depth == list.size()){
            list.add(node.val);
        }
        // 找 right most 的 node
        dfs(node.right, list, depth + 1);
        dfs(node.left, list, depth + 1);

    }
}
