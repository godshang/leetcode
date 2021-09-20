package q138_copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {

    Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        if (visited.containsKey(head)) {
            return visited.get(head);
        }
        Node node = new Node(head.val);
        visited.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    public static void main(String[] args) {

        Node n1 = new Node(7), n2 = new Node(13), n3 = new Node(11), n4 = new Node(10), n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Solution solution = new Solution();
        Node r = solution.copyRandomList(n1);
        while (r != null) {
            System.out.print(r.val);
            if (r.random != null) {
                System.out.print(" " + r.random.val);
            }
            r = r.next;
            System.out.println();
        }
    }
}

