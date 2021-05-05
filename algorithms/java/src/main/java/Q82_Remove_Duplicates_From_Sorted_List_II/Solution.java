package q82_remove_duplicates_from_sorted_list_ii;

import common.ListNode;
import common.Util;

public class Solution {

        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode dummy = new ListNode(), p = dummy;
            dummy.next = head;
            while (p.next != null && p.next.next != null) {
                boolean duplicated = false;
                while (p.next.next != null && p.next.val == p.next.next.val) {
                    duplicated = true;
                    p.next.next = p.next.next.next;
                }
                if (duplicated) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            return dummy.next;
        }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.deleteDuplicates(Util.buildList(new int[]{1, 2, 3, 3, 4, 4, 5})));
    }
}
