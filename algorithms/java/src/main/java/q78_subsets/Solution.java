package q78_subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        return subsets(nums, nums.length - 1);
    }

    private List<List<Integer>> subsets(int[] nums, int end) {
        if (end < 0) {
            List<Integer> inner = new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();
            list.add(inner);
            return list;
        }

        int last = nums[end];
        List<List<Integer>> list = subsets(nums, end - 1);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            List<Integer> tmp = new ArrayList<>(list.get(i));
            tmp.add(last);
            list.add(tmp);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
