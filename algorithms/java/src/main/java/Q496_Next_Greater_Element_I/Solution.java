package q496_next_greater_element_i;

import common.Util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        Util.printArray(solution.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}));
        Util.printArray(solution.nextGreaterElement(new int[]{1, 3, 5, 2, 4}, new int[]{6, 5, 4, 3, 2, 1, 7}));
    }
}
