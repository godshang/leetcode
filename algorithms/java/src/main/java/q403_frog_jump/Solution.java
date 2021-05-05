package q403_frog_jump;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canCross(int[] stones) {
        Map<String, Boolean> map = new HashMap<>();
        return helper(stones, 0, 0, map);
    }

    private boolean helper(int[] stones, int index, int k, Map<String, Boolean> map) {
        String key = index + "_" + k;
        if (map.containsKey(key)) {
            return false;
        } else {
            map.put(key, true);
        }
        for (int i = index + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[index];
            if (gap >= k - 1 && gap <= k + 1) {
                if (helper(stones, i, gap, map)) {
                    return true;
                }
            }
            if (gap > k + 1) {
                break;
            }
            if (gap < k - 1) {
                continue;
            }
        }
        if (index == stones.length - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(solution.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }
}
