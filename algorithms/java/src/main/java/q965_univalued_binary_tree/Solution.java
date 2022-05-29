package q965_univalued_binary_tree;

import common.TreeNode;

import java.util.Objects;

public class Solution {

    public boolean isUnivalTree(TreeNode root) {
        Boolean ans = dfs(root, root.val);
        return Objects.nonNull(ans) && ans;
    }

    private Boolean dfs(TreeNode node, int v) {
        if (node == null) return null;
        if (node.val != v) return Boolean.FALSE;

        Boolean left = dfs(node.left, v);
        if (Objects.nonNull(left) && !left) return Boolean.FALSE;
        Boolean right = dfs(node.right, v);
        if (Objects.nonNull(right) && !right) return Boolean.FALSE;

        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        System.out.println(solution.isUnivalTree(root));
    }
}
