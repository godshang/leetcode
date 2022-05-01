package q1305_all_elements_in_two_binary_search_trees;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        dfs(root1, list1); dfs(root2, list2);
        int i = 0, j = 0, n1 = list1.size(), n2 = list2.size();
        List<Integer> ans = new ArrayList<>(n1 + n2);
        while (i < n1 || j < n2) {
            int a = i < n1 ? list1.get(i) : Integer.MAX_VALUE;
            int b = j < n2 ? list2.get(j) : Integer.MAX_VALUE;
            if (a <= b) {
                ans.add(a); i++;
            } else {
                ans.add(b); j++;
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        System.out.println(solution.getAllElements(root1, root2));
    }
}
