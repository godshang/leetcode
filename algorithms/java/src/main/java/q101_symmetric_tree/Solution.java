package q101_symmetric_tree;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return magic(root.left, root.right);
    }

    private boolean magic(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return (left.val == right.val) 
            && magic(left.left, right.right)
            && magic(left.right, right.left);
    }

    public boolean isSymmetric_Queue(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>(), q2 = new LinkedList<TreeNode>();
        q1.offer(root.left);
        q2.offer(root.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll(), n2 = q2.poll();
            if (n1 == null && n2 == null) continue;
            if ((n1 !=null && n2 == null) || (n1 == null && n2 != null)) return false;
            if (n1.val != n2.val) return false;
            q1.offer(n1.left);
            q1.offer(n1.right);
            q2.offer(n2.right);
            q2.offer(n2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2); r1.right = new TreeNode(2);
        r1.left.left = new TreeNode(3); r1.left.right = new TreeNode(4);
        r1.right.left = new TreeNode(4); r1.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric_Queue(r1));

        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(2); r2.right = new TreeNode(2);
        r2.left.right = new TreeNode(3);
        r2.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric_Queue(r2));
    }
}
