package q606_construct_string_from_binary_tree;

import common.TreeNode;

public class Solution {

    public String tree2str(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "";
        else if (root.right == null) return root.val + "(" + tree2str(root.left) + ")";
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(solution.tree2str(root));
    }
}
