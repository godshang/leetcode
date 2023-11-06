package q513_find_bottom_left_tree_value;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            ans = queue.peek().val;
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(solution.findBottomLeftValue(root));
    }
}
