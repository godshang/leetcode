package q124_binary_tree_maximum_path_sum;

import common.TreeNode;

public class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftGain = Math.max(dfs(root.left), 0);
        int rightGain = Math.max(dfs(root.right), 0);

        int priceNewPath = root.val + leftGain + rightGain;
        maxSum = Math.max(priceNewPath, maxSum);

        return root.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(solution.maxPathSum(root));
    }
}
