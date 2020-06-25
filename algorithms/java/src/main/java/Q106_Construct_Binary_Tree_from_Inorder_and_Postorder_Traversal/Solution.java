package Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import common.BTreePrinter;
import common.TreeNode;

import java.util.Arrays;

public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++) {
            if (postorder[postorder.length - 1] != inorder[i]) continue;

            int[] in_left = Arrays.copyOfRange(inorder, 0, i);
            int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
            int[] post_left = Arrays.copyOfRange(postorder, 0, i);
            int[] post_right = Arrays.copyOfRange(postorder, i, postorder.length - 1);
            root.left = buildTree(in_left, post_left);
            root.right = buildTree(in_right, post_right);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        BTreePrinter.printNode(root);
    }
}
