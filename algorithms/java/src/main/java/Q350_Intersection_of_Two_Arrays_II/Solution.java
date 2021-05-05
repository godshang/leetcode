package q350_intersection_of_two_arrays_ii;

import common.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                res.add(num);
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return res.stream().mapToInt(e -> e.intValue()).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Util.printArray(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Util.printArray(solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }
}
