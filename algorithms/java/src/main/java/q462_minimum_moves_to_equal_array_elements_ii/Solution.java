package q462_minimum_moves_to_equal_array_elements_ii;

import java.util.Arrays;

public class Solution {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, left = 0, right = nums.length - 1;
        while (left < right) {
            ans += nums[right] - nums[left];
            left++;
            right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMoves2(new int[]{1, 2, 3}));
        System.out.println(solution.minMoves2(new int[]{1, 10, 2, 9}));
    }
}
