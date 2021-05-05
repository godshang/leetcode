package q235_lowest_common_ancestor_of_a_binary_search_tree;

import common.BTreePrinter;
import common.TreeNode;
import common.Util;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null)
            return null;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = Util.buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        BTreePrinter.printNode(root);

        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);
    }
}
