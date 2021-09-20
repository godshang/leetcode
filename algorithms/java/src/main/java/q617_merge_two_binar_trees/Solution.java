package q617_merge_two_binar_trees;

import common.TreeNode;
import common.Util;

public class Solution {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        TreeNode root = new TreeNode((root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0));
        root.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        root.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root1 = Util.buildTree(new Integer[]{1, 3, 2, 5, null, null, null});
        TreeNode root2 = Util.buildTree(new Integer[]{2, 1, 3, null, 4, null, 7});
        TreeNode root = solution.mergeTrees(root1, root2);
        Util.printTree(root);
    }
}
