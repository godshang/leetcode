package q107_binary_tree_level_order_traversal_ii;

import java.util.*;

import common.TreeNode;

public class Solution {

    public List<List<Integer>> levelOrderBottom_II(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(0, list);
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root != null) {
            doLevelOrderBottom(root, res, 0);
        }
        return res;
    }

    private void doLevelOrderBottom(TreeNode node, List<List<Integer>> res, int level) {
        if (res.size() - 1 < level) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            res.add(0, list);
        } else {
            List<Integer> list = res.get(res.size() - 1 - level);
            list.add(node.val);
        }
        if (node.left != null)
            doLevelOrderBottom(node.left, res, level + 1);
        if (node.right != null)
            doLevelOrderBottom(node.right, res, level + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);
        System.out.println(solution.levelOrderBottom_II(r));
    }
}
