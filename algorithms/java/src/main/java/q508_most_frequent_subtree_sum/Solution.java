package q508_most_frequent_subtree_sum;

import common.TreeNode;
import common.Util;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int max = map.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        int[] ans = map.entrySet().stream().filter(e -> e.getValue() == max).map(e -> e.getKey()).mapToInt(Integer::intValue).toArray();
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int sum = node.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        Util.printArray(solution.findFrequentTreeSum(root));
    }
}
