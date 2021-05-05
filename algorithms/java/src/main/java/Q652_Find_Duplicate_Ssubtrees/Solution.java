package q652_find_duplicate_ssubtrees;

import common.BTreePrinter;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private Map<String, Integer> countMap = new HashMap<>();
    
    private List<TreeNode> res = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }
    
    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;
        
        int count = countMap.getOrDefault(subTree, 0);
        if (count == 1) {
            res.add(root);
        }
        countMap.put(subTree, count + 1);
        return subTree;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        List<TreeNode> list = solution.findDuplicateSubtrees(root);
        for (TreeNode node : list) {
            BTreePrinter.printNode(node);
        }
    }
}
