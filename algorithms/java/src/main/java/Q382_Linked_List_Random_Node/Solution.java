package q382_linked_list_random_node;

import common.ListNode;
import common.Util;

import java.util.Random;

public class Solution {

    private ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        Random random = new Random();
        int i = 0, res = 0;
        ListNode p = head;
        while (p != null) {
            if (random.nextInt(++i) == 0) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(Util.buildList(new int[]{1, 2, 3}));
        System.out.println(solution.getRandom());
    }
}
