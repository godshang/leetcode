package q1022_sum_of_root_to_leaf_binary_numbers;

import common.TreeNode;

public class Solution {

    int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int cur) {
        int ncur = (cur << 1) + node.val;
        if (node.left != null) dfs(node.left, ncur);
        if (node.right != null) dfs(node.right, ncur);
        if (node.left == null && node.right == null) ans += ncur;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(solution.sumRootToLeaf(root));
    }
}
