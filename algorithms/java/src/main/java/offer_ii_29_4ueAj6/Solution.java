package offer_ii_29_4ueAj6;

public class Solution {

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node t = new Node(insertVal);
        t.next = t;
        if (head == null) return t;

        Node ans = head;
        int min = head.val, max = head.val;
        while (head.next != ans) {
            head = head.next;
            min = Math.min(min, head.val);
            max = Math.max(max, head.val);
        }

        if (min == max) {
            t.next = ans.next;
            ans.next = t;
        } else {
            while (!(head.val == max && head.next.val == min)) head = head.next;
            while (!(insertVal <= min || insertVal >= max) && !(head.val <= insertVal && insertVal <= head.next.val)) head = head.next;
            t.next = head.next;
            head.next = t;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node n1 = new Node(3), n2 = new Node(4), n3= new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        solution.insert(n1, 2);

        Node p = n1;
        while (p.next != n1) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.print(p.val + " ");
    }
}
