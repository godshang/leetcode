package q416_partition_equal_subset_sum;

public class Solution {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) sum += num;
        // 和为奇数时，不可能划分成两个和相等的集合
        if (sum % 2 != 0) return false;

        int N = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[N + 1][sum + 1];
        // base case
        for (int i = 0; i <= N; i++) dp[i][0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
    }
}
