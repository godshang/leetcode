package q12_sum_root_to_leaf_numbers;

import common.TreeNode;

public class Solution {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return sum;
    }

    private void dfs(TreeNode root, String parent) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            sum += Integer.parseInt(parent + root.val);
        if (root.left != null) dfs(root.left, parent + root.val);
        if (root.right != null) dfs(root.right, parent + root.val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        TreeNode r1 = new TreeNode(1);
//        r1.left = new TreeNode(2);
//        r1.right = new TreeNode(3);
//        System.out.println(solution.sumNumbers(r1));

        TreeNode r2 = new TreeNode(4);
        r2.left = new TreeNode(9);
        r2.right = new TreeNode(0);
        r2.left.left = new TreeNode(5);
        r2.left.right = new TreeNode(1);
        System.out.println(solution.sumNumbers(r2));
    }
}
