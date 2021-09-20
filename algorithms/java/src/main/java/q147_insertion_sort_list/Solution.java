package q147_insertion_sort_list;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();

        while (head != null) {
            ListNode p = dummy;
            while (p != null && p.next != null && p.next.val < head.val) {
                p = p.next;
            }
            ListNode next = head.next;
            head.next = p.next;
            p.next = head;
            head = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.insertionSortList(Util.buildList(new int[]{4, 2, 1, 3})));
        Util.printList(solution.insertionSortList(Util.buildList(new int[]{-1, 5, 3, 4, 0})));
    }
}
