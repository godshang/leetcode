package q110_balanced_binary_tree;

import common.TreeNode;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (helper(root) == -1) return false;
        return true;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        if (left == -1 || right == -1 || Math.abs(right - left) > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode r1 = new TreeNode(3);
        r1.left = new TreeNode(9);
        r1.right = new TreeNode(20);
        r1.right.left = new TreeNode(15);
        r1.right.right = new TreeNode(7);
        System.out.println(solution.isBalanced(r1));

        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(2);
        r2.right = new TreeNode(2);
        r2.left.left = new TreeNode(3);
        r2.left.right = new TreeNode(3);
        r2.left.left.left = new TreeNode(4);
        r2.left.left.right = new TreeNode(4);
        System.out.println(solution.isBalanced(r2));
    }
}
