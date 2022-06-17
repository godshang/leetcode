package q532_k_diff_pairs_in_an_array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        int ans = 0;
        for (int x : nums) {
            if (map.get(x) == 0) continue;
            if (k == 0) {
                if (map.get(x) > 1) ans++;
            } else {
                int a = x - k, b = x + k;
                if (map.getOrDefault(a, 0) > 0) ans++;
                if (map.getOrDefault(b, 0) > 0) ans++;
            }
            map.put(x, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }
}
