package q257_binary_tree_paths;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root != null)
            doBinaryTreePaths(root, "", list);
        return list;
    }

    private void doBinaryTreePaths(TreeNode node, String path, List<String> list) {
        if (node.left == null && node.right == null) list.add(path + node.val);
        if (node.left != null) doBinaryTreePaths(node.left, path + node.val + "->", list);
        if (node.right != null) doBinaryTreePaths(node.right, path + node.val + "->", list);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> list = solution.binaryTreePaths(root);
        System.out.println(list);
    }
}
