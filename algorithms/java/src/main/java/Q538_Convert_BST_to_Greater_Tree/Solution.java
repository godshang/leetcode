package q538_convert_bst_to_greater_tree;

import common.BTreePrinter;
import common.TreeNode;
import common.Util;

public class Solution {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = Util.buildTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        BTreePrinter.printNode(solution.convertBST(root));
    }
}
