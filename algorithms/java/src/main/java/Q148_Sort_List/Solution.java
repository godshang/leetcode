package q148_sort_list;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int len = lenghtOf(head);
        ListNode dummy = new ListNode(), cur, left, right, tail;
        dummy.next = head;
        for (int step = 1; step < len; step *= 2) {
            cur = dummy.next;
            tail = dummy;
            while (cur != null) {
                left = cur;
                right = cut(cur, step);
                cur = cut(right, step);
                tail.next = merge(left, right);
                while (tail.next != null) tail = tail.next;
            }
        }
        return dummy.next;
    }

    private int lenghtOf(ListNode head) {
        if (head == null) return 0;
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }
        return i;
    }

    private ListNode cut(ListNode head, int n) {
        if (head == null) return head;
        ListNode pre = head;
        while (n > 0 && head != null) {
            pre = head;
            head = head.next;
            n--;
        }
        pre.next = null;
        return head;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(), p = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        p.next = h1 != null ? h1 : h2;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Util.printList(solution.sortList(Util.buildList(new int[]{4, 2, 1, 3})));
        Util.printList(solution.sortList(Util.buildList(new int[]{-1, 5, 3, 4, 0})));
    }
}
