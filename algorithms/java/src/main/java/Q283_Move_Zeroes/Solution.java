package q283_move_zeroes;

import common.Util;

public class Solution {

    public void moveZeroes(int[] nums) {
        int lastNonZeroPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroPos++] = nums[i];
            }
        }
        for (int i = lastNonZeroPos; i < nums.length; i++)
            nums[i] = 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        Util.printArray(nums);
    }
}
