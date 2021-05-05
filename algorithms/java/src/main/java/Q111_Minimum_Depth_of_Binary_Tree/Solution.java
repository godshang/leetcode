package q111_minimum_depth_of_binary_tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null)
                    return depth;
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }

    public int minDepth_dfs(TreeNode root) {
        if (root == null) return 0;
        return helper(root, Integer.MAX_VALUE, 1);
    }

    private int helper(TreeNode node, int min, int depth) {
        if (node.left == null && node.right == null)
            return Math.min(min, depth);
        
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (node.left != null)
            left = helper(node.left, min, depth + 1);
        if (node.right != null)
            right = helper(node.right, min , depth + 1);
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);
        System.out.println(solution.minDepth(r));
    }
}
