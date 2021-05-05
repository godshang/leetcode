package q95_unique_binary_search_trees_ii;

import common.BTreePrinter;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();
        return doGenerateTrees(1, n);
    }

    private List<TreeNode> doGenerateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = doGenerateTrees(start, i - 1);
            List<TreeNode> rightTrees = doGenerateTrees(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> list = solution.generateTrees(3);
        System.out.println(list.size());
        for (TreeNode root : list) {
            BTreePrinter.printNode(root);
        }
    }
}
