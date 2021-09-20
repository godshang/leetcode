package q429_n_ary_tree_level_order_traversal;

import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> list = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                tmp.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            list.add(tmp);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add((new Node(4)));

        Node node = root.children.get(0);
        node.children = new ArrayList<>();
        node.children.add(new Node(5));
        node.children.add(new Node(6));

        System.out.println(solution.levelOrder(root));
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
