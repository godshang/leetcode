package pq_04_06_successor_lcci;

import common.TreeNode;

public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) return inorderSuccessor(root.right, p);
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(solution.inorderSuccessor(root, root.left));
    }
}
