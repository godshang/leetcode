package q230_kth_smallest_element_in_a_bst;

import common.TreeNode;

public class Solution {

    private int res = 0;
    private int rank = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    
    private void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(solution.kthSmallest(root, 1));
    }
}
