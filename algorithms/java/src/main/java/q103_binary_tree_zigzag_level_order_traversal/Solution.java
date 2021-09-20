package q103_binary_tree_zigzag_level_order_traversal;

import common.TreeNode;
import common.Util;

import java.util.*;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        boolean rightToLeft = false;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>(size);
            Deque<TreeNode> help = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = rightToLeft ? deque.pollLast() : deque.pollFirst();
                level.add(node.val);
                if (rightToLeft) {
                    if (node.right != null) help.offerFirst(node.right);
                    if (node.left != null) help.offerFirst(node.left);
                } else {
                    if (node.left != null) help.offerLast(node.left);
                    if (node.right != null) help.offerLast(node.right);
                }
            }
            deque.addAll(help);
            result.add(level);
            rightToLeft = !rightToLeft;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.zigzagLevelOrder(Util.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
