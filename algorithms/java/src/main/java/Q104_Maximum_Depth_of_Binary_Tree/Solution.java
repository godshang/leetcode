package q104_maximum_depth_of_binary_tree;

import common.TreeNode;

public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode r1 = new TreeNode(3);
        r1.left = new TreeNode(9);
        r1.right = new TreeNode(20);
        r1.right.left = new TreeNode(15);
        r1.right.right = new TreeNode(7);
        System.out.println(solution.maxDepth(r1));
    }
}
