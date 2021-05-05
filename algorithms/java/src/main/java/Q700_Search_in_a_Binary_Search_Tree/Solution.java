package q700_search_in_a_binary_search_tree;

import common.BTreePrinter;
import common.TreeNode;
import common.Util;

public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val)
            return root;
        else if (root.val < val)
            return searchBST(root.right, val);
        else if (root.val > val)
            return searchBST(root.left, val);
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = Util.buildTree(new Integer[]{4, 2, 7, 1, 3});
        BTreePrinter.printNode(root);
        BTreePrinter.printNode(solution.searchBST(root, 2));
    }
}
