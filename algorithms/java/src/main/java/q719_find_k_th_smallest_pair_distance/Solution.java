package q719_find_k_th_smallest_pair_distance;

import java.util.Arrays;

public class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = (int) 1e6;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    private int check(int[] nums, int x) {
        int n = nums.length, ans = 0;
        for (int i = 0, j = 1; i < n; i++) {
            while (j < n && nums[j] - nums[i] <= x) j++;
            ans += j - i - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestDistancePair(new int[]{1, 3, 1}, 1));
        System.out.println(solution.smallestDistancePair(new int[]{1, 1, 1}, 2));
        System.out.println(solution.smallestDistancePair(new int[]{1, 6, 1}, 3));
    }
}
