package Q107_Binary_Tree_Level_Order_Traversal_II;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class Solution {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root != null) {
            doLevelOrderBottom(root, res, 0);
        }
        return res;
    }

    private void doLevelOrderBottom(TreeNode node, List<List<Integer>> res, int level) {
        if (res.size() - 1 < level) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            res.add(0, list);
        } else {
            List<Integer> list = res.get(res.size() - 1 - level);
            list.add(node.val);
        }
        if (node.left != null)
            doLevelOrderBottom(node.left, res, level + 1);
        if (node.right != null)
            doLevelOrderBottom(node.right, res, level + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);
        System.out.println(solution.levelOrderBottom(r));
    }
}