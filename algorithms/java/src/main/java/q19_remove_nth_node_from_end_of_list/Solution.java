package q19_remove_nth_node_from_end_of_list;

import common.ListNode;

import static common.Util.printList;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode h = new ListNode(1);
        ListNode n = h;
//        n.next = new common.ListNode(2); n = n.next;
//        n.next = new common.ListNode(3); n = n.next;
//        n.next = new common.ListNode(4); n = n.next;
//        n.next = new common.ListNode(5); n = n.next;

        printList(h);
        ListNode r = solution.removeNthFromEnd(h, 1);
        printList(r);
    }
}
