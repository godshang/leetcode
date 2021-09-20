package q1019_next_greater_node_in_linked_list;

import common.ListNode;
import common.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return null;
        Stack<Integer> monoStack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        int index = 0;
        while (head != null) {
            res.add(0);
            data.add(head.val);
            while (!monoStack.isEmpty() && head.val > data.get(monoStack.peek())) {
                res.set(monoStack.pop(), head.val);
            }
            monoStack.push(index);
            index++;
            head = head.next;
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.nextLargerNodes(Util.buildList(new int[]{2, 1, 5})));
        Util.printArray(solution.nextLargerNodes(Util.buildList(new int[]{2, 7, 4, 3, 5})));
        Util.printArray(solution.nextLargerNodes(Util.buildList(new int[]{1, 7, 5, 1, 9, 2, 5, 1})));
    }
}
