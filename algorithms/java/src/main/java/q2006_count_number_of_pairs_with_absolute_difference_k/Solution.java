package q2006_count_number_of_pairs_with_absolute_difference_k;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ans += cnt.getOrDefault(nums[i] - k, 0) + cnt.getOrDefault(nums[i] + k, 0);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countKDifference(new int[]{1, 2, 2, 1}, 1));
    }
}
