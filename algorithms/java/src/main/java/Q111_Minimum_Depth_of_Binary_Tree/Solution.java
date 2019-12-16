package Q111_Minimum_Depth_of_Binary_Tree;

import common.TreeNode;

public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, Integer.MAX_VALUE, 1);
    }

    private int helper(TreeNode node, int min, int depth) {
        if (node.left == null && node.right == null)
            return Math.min(min, depth);
        
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (node.left != null)
            left = helper(node.left, min, depth + 1);
        if (node.right != null)
            right = helper(node.right, min , depth + 1);
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);
        System.out.println(solution.minDepth(r));
    }
}