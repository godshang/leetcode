package Q24_Swap_Nodes_in_Pairs;

import common.ListNode;

import static common.Util.printList;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode n = node2.next;
            node2.next = node1;
            node1.next = n;
            p.next = node2;
            p = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        printList(solution.swapPairs(head));
    }
}
