package q83_remove_duplicates_from_sorted_list;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = head.next;
        int prev = head.val;
        while (q != null) {
            if (q.val == prev) {
                q = q.next;
                p.next = q;
            } else {
                prev = q.val;
                p = q;
                q = q.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode l1 = Util.buildList(new int[] {1, 1, 2});
        Util.printList(solution.deleteDuplicates(l1));

        ListNode l2 = Util.buildList(new int[] {1, 1, 2, 3, 3});
        Util.printList(solution.deleteDuplicates(l2));
    }
}
