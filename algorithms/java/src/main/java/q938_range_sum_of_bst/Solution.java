package q938_range_sum_of_bst;

import common.TreeNode;
import common.Util;

public class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        
        if (root.val > high)
            return rangeSumBST(root.left, low, high);
        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
    
    public static void main(String[] args) {
        TreeNode root = Util.buildTree(new Integer[]{10, 5, 15, 3, 7, null, 18});
        
        Solution solution = new Solution();
        System.out.println(solution.rangeSumBST(root, 7, 15));
    }
}
