package q1480_running_sum_of_1d_array;

import common.Util;

public class Solution {

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.runningSum(new int[]{1, 2, 3, 4}));
    }
}
