package q437_path_sum_iii;

import common.TreeNode;
import common.Util;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int pathSum(TreeNode root, int sum) {
        List<Integer> sumList = new ArrayList<>();
        return dfs(root, sum, sumList);
    }

    private int dfs(TreeNode root, int sum, List<Integer> sumList) {
        if (root == null) return 0;
        List<Integer> list = new ArrayList<>(sumList);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + root.val);
        }
        list.add(root.val);
        return countSum(list, sum) + dfs(root.left, sum, list) + dfs(root.right, sum, list);
    }

    private int countSum(List<Integer> list, int sum) {
        int count = 0;
        for (Integer i : list) {
            if (i == sum) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = Util.buildTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(solution.pathSum(root, 8));
    }
}
