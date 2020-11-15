package Q701_Insert_into_a_Binary_Search_Tree;

import common.BTreePrinter;
import common.TreeNode;
import common.Util;

public class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) 
            root.right = insertIntoBST(root.right, val);
        if (root.val > val) 
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = Util.buildTree(new Integer[]{4, 2, 7, 1, 3});
        solution.insertIntoBST(root, 5);
        BTreePrinter.printNode(root);
    }
}
