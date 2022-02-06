package q1748_sum_of_unique_elements;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int num : cnt.keySet()) {
            if (cnt.get(num) == 1) {
                ans += num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfUnique(new int[]{1, 2, 3, 2}));
        System.out.println(solution.sumOfUnique(new int[]{1, 1, 1, 1, 1}));
    }
}
