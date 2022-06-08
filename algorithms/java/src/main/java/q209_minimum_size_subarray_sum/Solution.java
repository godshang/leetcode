package q209_minimum_size_subarray_sum;

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, ans = Integer.MAX_VALUE;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int s = sum[i], d = s - target;
            int l = 0, r = i;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (sum[mid] <= d) l = mid;
                else r = mid - 1;
            }
            if (sum[r] <= d) ans = Math.min(ans, i - r);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(solution.minSubArrayLen(11, new int[]{11, 4, 4}));
    }
}
