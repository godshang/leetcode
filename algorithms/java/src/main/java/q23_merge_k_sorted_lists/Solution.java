package q23_merge_k_sorted_lists;

import common.ListNode;

import java.util.PriorityQueue;

import static common.Util.printList;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode r = head;

        while (true) {
            boolean terminate = true;
            for (ListNode n : lists) {
                if (n != null) {
                    terminate = false;
                    break;
                }
            }
            if (terminate) {
                break;
            }

            ListNode cur = lists[0];
            int pos = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode n = lists[i];
                if (cur == null || (n != null && n.val < cur.val)) {
                    cur = n;
                    pos = i;
                }
            }
            lists[pos] = lists[pos].next;

            r.next = cur;
            r = r.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[] {l1, l2, l3};
        Solution solution = new Solution();
        printList(solution.mergeKLists(lists));
    }

}
