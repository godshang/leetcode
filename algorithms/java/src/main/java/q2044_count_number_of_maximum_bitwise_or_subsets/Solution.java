package q2044_count_number_of_maximum_bitwise_or_subsets;

public class Solution {

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length, mask = 1 << n;
        int max = 0, ans = 0;
        for (int i = 0; i < mask; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) cur |= nums[j];
            }
            if (cur > max) {
                max = cur;
                ans = 1;
            } else if (cur == max) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(solution.countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(solution.countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }
}
