package q114_flatten_binary_tree_to_linked_list;

import common.BTreePrinter;
import common.TreeNode;

public class Solution {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = root.right;
                root.right = root.left;
                root.left = null;

                root = root.right;
            }
        }
    }
    
    public void flatten_2(TreeNode root) {
        if (root == null) return;
        
        flatten_2(root.left);
        flatten_2(root.right);
        
        TreeNode left = root.left, right = root.right;
        root.left = null;
        root.right = left;
        
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Solution solution = new Solution();
        solution.flatten_2(root);
        BTreePrinter.printNode(root);
    }
}
