package q108_convert_sorted_array_to_binary_search_tree;

import common.BTreePrinter;
import common.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int left, int right) {
        TreeNode node = null;
        if (left <= right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) / 2;
            node = new TreeNode(nums[mid]);
            node.left = toBST(nums, left, mid - 1);
            node.right = toBST(nums, mid + 1, right);
        }
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
        BTreePrinter.printNode(node);
    }
}
