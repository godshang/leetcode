package q145_binary_tree_postorder_traversal;

import common.TreeNode;

import java.util.*;

public class Solution {

    public List<Integer> postorderTraversal_4(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode t = null;
        if (root == null) return null;
        TreeNode tmp = root;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            if (tmp.right == null || (t != null && t.right == null)) {
                ans.add(tmp.val);
                t = tmp;
            } else {
                tmp = tmp.right;
                stack.push(tmp);
                while (tmp != null) {
                    stack.push(tmp);
                    tmp = tmp.left;
                }
            }
        }
        return ans;
    }

    public List<Integer> postorderTraversal_3(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        while (!s1.empty()) {
            TreeNode cur = s1.pop();
            resultList.add(cur.val);
            if (cur.right != null) s1.push(cur.right);
            if (cur.left != null) s1.push(cur.left);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = resultList.size() - 1; i >= 0; i--) {
            res.add(resultList.get(i));
        }
        return res;
    }

    public List<Integer> postorderTraversal_2(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.empty()) {
            TreeNode cur = s1.pop();
            s2.push((cur));
            if (cur.left != null)
                s1.push(cur.left);
            if (cur.right != null)
                s1.push(cur.right);
        }
        while (!s2.empty()) {
            resultList.add(s2.pop().val);
        }
        return resultList;
    }

    // 左->右->父
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                resultList.add(stack.pop().val);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(solution.postorderTraversal(root));
//        System.out.println(solution.postorderTraversal_2(root));
//        System.out.println(solution.postorderTraversal_3(root));
        System.out.println(solution.postorderTraversal_4(root));
    }
}
