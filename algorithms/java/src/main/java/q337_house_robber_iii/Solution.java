package q337_house_robber_iii;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return rob(root, memo);
    }

    private int rob(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int rob = root.val
                + (root.left == null ? 0 : rob(root.left.left, memo) + rob(root.left.right, memo))
                + (root.right == null ? 0 : rob(root.right.left, memo) + rob(root.right.right, memo));
        int notRob = rob(root.left, memo) + rob(root.right, memo);
        int res = Math.max(rob, notRob);
        memo.put(root, res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode r1 = new TreeNode(3);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(3);
        r1.left.right = new TreeNode(3);
        r1.right.right = new TreeNode(1);
        System.out.println(solution.rob(r1));

        TreeNode r2 = new TreeNode(3);
        r2.left = new TreeNode(4);
        r2.right = new TreeNode(5);
        r2.left.left = new TreeNode(1);
        r2.left.right = new TreeNode(3);
        r2.right.right = new TreeNode(1);
        System.out.println(solution.rob(r2));
    }
}
