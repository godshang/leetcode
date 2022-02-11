package q1984_minimum_difference_between_highest_and_lowest_of_k_scores;

import java.util.Arrays;

public class Solution {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; i++) {
            int diff = nums[i + k - 1] - nums[i];
            ans = Math.min(ans, diff);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDifference(new int[]{90}, 1));
        System.out.println(solution.minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }
}
