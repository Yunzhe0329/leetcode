import java.util.ArrayList;
import java.util.List;

class SolutionDFS {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> list, int depth) {
        if (node == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(node.val);
        }
        dfs(node.right, list, depth + 1);
        dfs(node.left, list, depth + 1);

    }
}