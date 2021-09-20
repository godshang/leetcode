package q144_binary_tree_preorder_traversal;

import common.TreeNode;

import java.util.*;

public class Solution {

    // 父->左->右
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                stack.push(node);
                stack.push(null);
            } else {
                resultList.add(stack.pop().val);
            }
        }
        return resultList;
    }

    public List<Integer> preorderTraversal_Recursive(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        dfs(root, resultList);
        return resultList;
    }

    private void dfs(TreeNode root, List<Integer> resultList) {
        if (root == null) return;
        resultList.add(root.val);
        dfs(root.left, resultList);
        dfs(root.right, resultList);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(solution.preorderTraversal(root));
    }
}
