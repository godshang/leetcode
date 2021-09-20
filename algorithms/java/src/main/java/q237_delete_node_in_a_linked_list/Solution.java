package q237_delete_node_in_a_linked_list;

import common.ListNode;
import common.Util;

public class Solution {

    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = Util.buildList(new int[]{4, 5, 1, 9});
        solution.deleteNode(l.next);
        Util.printList(l);
    }
}
