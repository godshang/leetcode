package q725_split_linked_list_in_parts;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode cur = root;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        int width = length / k, rem = length % k;
        ListNode[] result = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; i++) {
            ListNode head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
                if (cur != null) cur = cur.next;
            }
            if (cur != null) {
                ListNode pre = cur;
                cur = cur.next;
                pre.next = null;
            }
            result[i] = head;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (ListNode node : solution.splitListToParts(Util.buildList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 3)) {
            Util.printList(node);
        }
    }
}
