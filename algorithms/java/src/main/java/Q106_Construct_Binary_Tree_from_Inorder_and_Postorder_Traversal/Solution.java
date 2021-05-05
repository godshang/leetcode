package q106_construct_binary_tree_from_inorder_and_postorder_traversal;

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

    public TreeNode buildTree_2(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.buildTree_2(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        BTreePrinter.printNode(root);
    }
}
