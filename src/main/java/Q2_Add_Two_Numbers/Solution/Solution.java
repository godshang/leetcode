package Q2_Add_Two_Numbers.Solution;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        int val = 0, rem = 0;
        while (l1 != null || l2 != null) {
            val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + rem;
            rem = val / 10;
            prev.next = new ListNode(val % 10);
            prev = prev.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (rem > 0) {
            prev.next = new ListNode(rem);
        }
        return head.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution.ListNode l1 = new Solution.ListNode(2);
        Solution.ListNode n1 = l1;
        n1.next = new Solution.ListNode(4); n1 = n1.next;
        n1.next = new Solution.ListNode(3); n1 = n1.next;

        Solution.ListNode l2 = new Solution.ListNode(5);
        Solution.ListNode n2 = l2;
        n2.next = new Solution.ListNode(6); n2 = n2.next;
        n2.next = new Solution.ListNode(4); n2 = n2.next;

        Solution solution = new Solution();
        Solution.ListNode r = solution.addTwoNumbers(l1, l2);

        while (r != null) {
            System.out.print(r.val);
            if (r.next != null) {
                System.out.print(" -> ");
            }
            r = r.next;
        }
    }
}
