package q113_path_sum_ii;

import common.BTreePrinter;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> resultList = new ArrayList<>();
        helper(root, 0, sum, new ArrayList<>(), resultList);
        return resultList;
    }

    private void helper(TreeNode node, int sum, int target, List<Integer> pathList, List<List<Integer>> resultList) {
        pathList.add(node.val);
        if (node.left == null && node.right == null) {
            if ((sum + node.val) == target) {
                resultList.add(pathList);
            }
        }
        if (node.left != null) {
            helper(node.left, sum + node.val, target, new ArrayList<>(pathList), resultList);
        }
        if (node.right != null) {
            helper(node.right, sum + node.val, target, new ArrayList<>(pathList), resultList);
        }
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(5);
        r.left = new TreeNode(4);
        r.right = new TreeNode(8);
        r.left.left = new TreeNode(11);
        r.right.left = new TreeNode(13);
        r.right.right = new TreeNode(4);
        r.left.left.left = new TreeNode(7);
        r.left.left.right = new TreeNode(2);
        r.right.right.left = new TreeNode(5);
        r.right.right.right = new TreeNode(1);
        BTreePrinter.printNode(r);

        Solution solution = new Solution();
        System.out.println(solution.pathSum(r, 22));
    }
}
