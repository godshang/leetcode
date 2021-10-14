package q47_permutations_ii;

import common.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int[] used = new int[nums.length];
        backtrace(nums, res, track, used);
        return res;
    }

    private void backtrace(int[] nums, List<List<Integer>> res, LinkedList<Integer> track, int[] used) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            track.add(nums[i]);
            used[i] = 1;
            backtrace(nums, res, track, used);
            track.removeLast();
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Util.printList(solution.permuteUnique(new int[]{1, 2, 3}));
        Util.printList(solution.permuteUnique(new int[]{1, 1, 2}));
    }
}
