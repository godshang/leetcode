package q396_rotate_function;

public class Solution {

    /**
     * nums = [A0, A1, A2, A3]
     * SUM = A0 + A1 + A2 + 3
     * F0 = 0 * A0 + 1 * A1 + 2 * A2 + 3 * A3
     * F1 = 0 * A3 + 1 * A0 + 2 * A1 + 3 * A2
     *    = F0 + A0 + A1 + A2 - 3 * A3
     *    = F0 + SUM - 4 * A3
     * F2 = 0 * A2 + 1 * A3 + 2 * A0 + 3 * A1
     *    = F1 + A0 + A1 + A2 -3 * A2
     *    = F1 + SUM - 4 * A2
     * F3 = 0 * A1 + 1 * A2 + 2 * A3 + 3 * A0
     *    = F2 + SUM - 4 * A1
     *
     * F(i) = F(i - 1) + sum - n * nums[n - i]
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        int n = nums.length, f = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
            sum += nums[i];
        }
        int ans = f;
        for (int i = 1; i < n; i++) {
            f = f + sum - n * nums[n - i];
            ans = Math.max(ans, f);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxRotateFunction(new int[]{4, 3, 2, 6}));
    }
}
