package q817_linked_list_components;

import common.ListNode;
import common.Util;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numComponents(ListNode head, int[] G) {
        if (head == null) return 0;
        Set<Integer> gSet = new HashSet<>();
        for (int i : G) gSet.add(i);

        int count = 0;
        while (head != null) {
            if (gSet.contains(head.val) && (head.next == null || !gSet.contains(head.next.val))) count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numComponents(Util.buildList(new int[]{0, 2, 3, 4}), new int[]{0, 1, 3}));
    }
}
