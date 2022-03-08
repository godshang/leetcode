package q2104_sum_of_subarray_ranges;

public class Solution {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(solution.subArrayRanges(new int[]{1, 3, 3}));
        System.out.println(solution.subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }
}
