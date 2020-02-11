package Q160_Intersection_of_Two_Linked_Lists;

import common.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        ListNode pA = headA, pB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < (lenA - lenB); i++)
                pA = pA.next;
        } else {
            for (int i = 0; i < (lenB - lenA); i++)
                pB = pB.next;
        }
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }

    private int length(ListNode p) {
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
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
        System.out.println(solution.getIntersectionNode(h1, h2).val);
    }
}
