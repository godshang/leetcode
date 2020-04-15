package Q237_Delete_Node_in_a_Linked_List;

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
