package q31_next_permutation;

import common.Util;

import java.util.Arrays;

public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        int i = n - 2, j = n - 1, k = n - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if (i >= 0) {
            while (nums[i] >= nums[k]) {
                k--;
            }
            swap(nums, i, k);
        }
        Arrays.sort(nums, j, n);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1, 2, 3};
//        int[] nums = {3, 2, 1};
//        int[] nums = {1, 1, 5};
        int[] nums = {1, 2};
        solution.nextPermutation(nums);
        Util.printArray(nums);
    }
}
