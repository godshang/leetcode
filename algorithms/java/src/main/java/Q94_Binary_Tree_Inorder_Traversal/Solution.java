package q94_binary_tree_inorder_traversal;

import common.BTreePrinter;
import common.TreeNode;

import java.util.*;

public class Solution {

    public List<Integer> inorderTraversal_iteration(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doInorderTraversal(root, list);
        return list;
    }

    private void doInorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        doInorderTraversal(root.left, list);
        list.add(root.val);
        doInorderTraversal(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        BTreePrinter.printNode(root);

        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal_iteration(root));
    }
}
