package q2_add_two_numbers;

import common.ListNode;

import static common.Util.printList;

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


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode n1 = l1;
        n1.next = new ListNode(4); n1 = n1.next;
        n1.next = new ListNode(3); n1 = n1.next;

        ListNode l2 = new ListNode(5);
        ListNode n2 = l2;
        n2.next = new ListNode(6); n2 = n2.next;
        n2.next = new ListNode(4); n2 = n2.next;

        Solution solution = new Solution();
        ListNode r = solution.addTwoNumbers(l1, l2);

        printList(r);
    }
}
