package q112_path_sum;

import common.TreeNode;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, 0, sum);   
    }

    private boolean helper(TreeNode node, int sum, int target) {
        if (node.left == null && node.right == null) return (sum + node.val) == target;
        if (node.left != null && helper(node.left, sum + node.val, target)) return true;
        if (node.right != null && helper(node.right, sum + node.val, target)) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode r = new TreeNode(5);
        r.left = new TreeNode(4);
        r.right = new TreeNode(8);
        r.left.left = new TreeNode(11);
        r.right.left = new TreeNode(13);
        r.right.right = new TreeNode(4);
        r.left.left.left = new TreeNode(7);
        r.left.left.right = new TreeNode(2);
        r.right.right.right = new TreeNode(1);
        System.out.println(solution.hasPathSum(r, 22));
    }
}
