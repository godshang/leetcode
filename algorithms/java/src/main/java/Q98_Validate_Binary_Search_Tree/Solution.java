package q98_validate_binary_search_tree;

import common.TreeNode;
import common.Util;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        if ((lower != null && root.val <= lower) || (upper != null && root.val >= upper)) return false;
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isValidBST(Util.buildTree(new Integer[]{2, 1, 3})));
//        System.out.println(solution.isValidBST(Util.buildTree(new Integer[]{5, 1, 4, null, null, 3, 6})));
        System.out.println(solution.isValidBST(Util.buildTree(new Integer[]{2147483647})));
    }
}
