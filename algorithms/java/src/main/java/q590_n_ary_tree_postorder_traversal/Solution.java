package q590_n_ary_tree_postorder_traversal;

import common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                List<Node> children = node.children;
                if (children != null) {
                    for (int i = children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                    }
                }
            } else {
                ans.add(stack.pop().val);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node node = new Node(1, new ArrayList<>());
        node.children.add(new Node(3, new ArrayList<>()));
        node.children.add(new Node(2));
        node.children.add(new Node(4));
        node.children.get(0).children.add(new Node(5));
        node.children.get(0).children.add(new Node(6));
        System.out.println(solution.postorder(node));
    }
}
