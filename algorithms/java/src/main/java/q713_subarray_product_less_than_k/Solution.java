package q713_subarray_product_less_than_k;

public class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        if (k <= 1) return 0;
        for (int i = 0, j = 0, cur = 1; j < nums.length; j++) {
            cur *= nums[j];
            while (cur >= k) cur = cur / nums[i++];
            ans += j - i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{1, 2,3 }, 0));
    }
}
