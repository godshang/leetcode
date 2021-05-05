package q100_same_tree;

import common.TreeNode;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2); p1.right = new TreeNode(3);
        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2); q1.right = new TreeNode(3);
        System.out.println(solution.isSameTree(p1, q1));

        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);
        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);
        System.out.println(solution.isSameTree(p2, q2));

        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2); p3.right = new TreeNode(1);
        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(1); q3.right = new TreeNode(3);
        System.out.println(solution.isSameTree(p3, q3));
    }
}
