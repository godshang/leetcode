package q654_maximum_binary_tree;

import common.BTreePrinter;
import common.TreeNode;

public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) return null;

        int max = Integer.MIN_VALUE, index = -1;
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, high);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        BTreePrinter.printNode(solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }
}
