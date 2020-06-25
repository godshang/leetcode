package Q114_Flatten_Binary_Tree_to_Linked_List;

import common.BTreePrinter;
import common.TreeNode;
import sun.reflect.generics.tree.Tree;

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Solution solution = new Solution();
        solution.flatten(root);
        BTreePrinter.printNode(root);
    }
}
