package q606_construct_string_from_binary_tree;

import common.TreeNode;

import java.util.*;

public class Solution {

    public String tree2str(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "";
        else if (root.right == null) return root.val + "(" + tree2str(root.left) + ")";
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    public String tree2str2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Set<TreeNode> vis = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (vis.contains(node)) {
                sb.append(")");
            } else {
                stack.push(node);
                sb.append("(");
                sb.append(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                else if (node.right != null) sb.append("()");
                vis.add(node);
            }
        }
        return sb.substring(1, sb.length() - 1);
    }

    public String tree2str3(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<Object[]> stack = new ArrayDeque<>();
        stack.push(new Object[]{0, root});
        while (!stack.isEmpty()) {
            Object[] o = stack.pop();
            int loc = (Integer) o[0];
            TreeNode node = (TreeNode) o[1];
            if (loc == 0) {
                sb.append("(");
                sb.append(node.val);
                stack.push(new Object[]{1, node});
            } else if (loc == 1) {
                stack.push(new Object[]{2, node});
                if (node.right != null) stack.push(new Object[]{0, node.right});
                if (node.left != null) stack.push(new Object[]{0, node.left});
                else if (node.right != null) sb.append("()");
            } else if (loc == 2) {
                sb.append(")");
            }
        }
        return sb.substring(1, sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(solution.tree2str3(root));
    }
}
