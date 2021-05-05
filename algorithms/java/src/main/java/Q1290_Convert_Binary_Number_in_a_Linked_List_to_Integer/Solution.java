package q1290_convert_binary_number_in_a_linked_list_to_integer;

import common.ListNode;
import common.Util;

public class Solution {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) + head.val;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getDecimalValue(Util.buildList(new int[]{1, 0, 1})));
        System.out.println(solution.getDecimalValue(Util.buildList(new int[]{0})));
        System.out.println(solution.getDecimalValue(Util.buildList(new int[]{1})));
        System.out.println(solution.getDecimalValue(Util.buildList(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0})));
        System.out.println(solution.getDecimalValue(Util.buildList(new int[]{0, 0})));
    }
}
