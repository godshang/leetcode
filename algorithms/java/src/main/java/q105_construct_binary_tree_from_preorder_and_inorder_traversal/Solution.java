package q105_construct_binary_tree_from_preorder_and_inorder_traversal;

import common.BTreePrinter;
import common.TreeNode;

import java.util.Arrays;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] != inorder[i]) continue;

            int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);
            int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
            int[] in_left = Arrays.copyOfRange(inorder, 0, i);
            int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
            root.left = buildTree(pre_left, in_left);
            root.right = buildTree(pre_right, in_right);
        }
        return root;
    }

    public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) 
            return null;
        
        int rootVal = preorder[preStart];

        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.buildTree_2(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        BTreePrinter.printNode(root);
    }
}
