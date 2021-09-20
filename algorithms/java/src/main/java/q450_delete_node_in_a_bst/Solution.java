package q450_delete_node_in_a_bst;

import common.BTreePrinter;
import common.TreeNode;
import common.Util;

public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null) root = null;
            else if (root.right != null) {
                root.val = successor(root).val;
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root).val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root;
    }

    private TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = Util.buildTree(new Integer[]{1, null, 2});
        BTreePrinter.printNode(root);
        BTreePrinter.printNode(solution.deleteNode(root, 2));
    }
}
