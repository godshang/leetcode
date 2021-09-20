package q404_sum_of_left_leaves;

import common.TreeNode;

public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean flag) {
        if (root == null) return 0;
        if (flag && root.left == null && root.right == null) return root.val;
        return dfs(root.left, true) + dfs(root.right, false);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.sumOfLeftLeaves(root));
    }
}
