package q1995_count_special_quadruplets;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countQuadruplets(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            ans++;
                        }
                    }
                }
            }
        }

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int c = n - 2; c >= 2; c--) {
//            map.put(nums[c + 1], map.getOrDefault(nums[c + 1], 0) + 1);
//            for (int a = 0; a < c; a++) {
//                for (int b = a + 1; b < c; b++) {
//                    ans += map.getOrDefault(nums[a] + nums[b] + nums[c], 0);
//                }
//            }
//        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.countQuadruplets(new int[]{1, 2, 3, 6}));
        System.out.println(solution.countQuadruplets(new int[]{25, 69, 18, 24, 60, 7, 49}));
    }
}
