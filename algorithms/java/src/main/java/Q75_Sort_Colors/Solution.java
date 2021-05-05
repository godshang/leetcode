package q75_sort_colors;

import common.Util;

public class Solution {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, idx);
                idx++;
            }
        }
        for (int i = idx; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, idx);
                idx++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        Util.printArray(nums);
    }
}
