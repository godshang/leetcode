package q430_flatte_a_multilevel_doubly_linked_list;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}

public class Solution {

    public Node flatten(Node head) {
        if (head == null) return head;
        Node dummy = new Node(-1, null, head, null);
        flatten_dfs(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }

    private Node flatten_dfs(Node prev, Node cur) {
        if (cur == null) return prev;
        cur.prev = prev;
        prev.next = cur;

        Node next = cur.next;
        Node tail = flatten_dfs(cur, cur.child);
        cur.child = null;
        return flatten_dfs(tail, next);
    }

    private static Node buildList(int[] array) {
        Node dummy = new Node(-1), p = dummy;
        for (int i = 0; i < array.length; i++) {
            p.next = new Node(array[i]);
            p.next.prev = p;
            p = p.next;
        }
        dummy.next.prev = null;
        return dummy.next;
    }

    private static void print(Node head) {
        StringBuilder builder = new StringBuilder();
        if (head != null) builder.append(head.val);
        head = head.next;
        while (head != null) {
            builder.append("->").append(head.val);
            head = head.next;
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {

        Node n1 = buildList(new int[]{1, 2, 3, 4, 5, 6});
        Node n2 = buildList(new int[]{7, 8, 9, 10});
        Node n3 = buildList(new int[]{11, 12});
        n1.next.next.child = n2;
        n2.next.child = n3;

        Solution solution = new Solution();
        print(solution.flatten(n1));
    }
}
