package q152_maximum_product_subarray;

public class Solution {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] maxDP = new int[n];
        int[] minDP = new int[n];
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxDP[i] = Math.max(maxDP[i - 1] * nums[i], Math.max(nums[i], minDP[i - 1] * nums[i]));
            minDP[i] = Math.min(minDP[i - 1] * nums[i], Math.min(nums[i], maxDP[i - 1] * nums[i]));
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, maxDP[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxProduct(new int[]{2, 3, -2, 4}));
//        System.out.println(solution.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(solution.maxProduct(new int[]{-2, 3, -4}));
    }
}
