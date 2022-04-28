package q905_sort_array_by_parity;

import common.Util;

public class Solution {

    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) left++;
            while (left < right && nums[right] % 2 == 1) right--;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.sortArrayByParity(new int[]{3, 1, 2, 4}));
        Util.printArray(solution.sortArrayByParity(new int[]{0}));
    }
}
