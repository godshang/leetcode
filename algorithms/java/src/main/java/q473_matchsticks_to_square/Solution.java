package q473_matchsticks_to_square;

import java.util.Arrays;

public class Solution {

    int[] ms;
    int t;

    public boolean makesquare(int[] matchsticks) {
        ms = matchsticks;
        int sum = Arrays.stream(ms).sum();
        t = sum / 4;
        if (t * 4 != sum) return false;
        Arrays.sort(ms);
        return dfs(ms.length - 1, new int[4]);
    }

    private boolean dfs(int idx, int[] cur) {
        if (idx == -1) return true;
        for (int i = 0; i < 4; i++) {
            int u = ms[idx];
            if (cur[i] + u > t) continue;
            cur[i] += u;
            if (dfs(idx - 1, cur)) return true;
            cur[i] -= u;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(solution.makesquare(new int[]{3, 3, 3, 3, 4}));
    }
}
