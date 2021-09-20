package q160_intersection_of_two_linked_lists;

import common.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
            ListNode h1 = new ListNode(4);
        h1.next = new ListNode(1);
        ListNode h2 = new ListNode(5);
        h2.next = new ListNode(0);
        h2.next.next = new ListNode(1);
        ListNode join = new ListNode(8);
        join.next = new ListNode(4);
        join.next.next = new ListNode(5);
        h1.next.next = join;
        h2.next.next.next = join;

        Solution solution = new Solution();
        System.out.println(solution.getIntersectionNode(h1, h2));
    }
}
