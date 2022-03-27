package q2028_find_missing_observations;

import common.Util;

import java.util.Arrays;

public class Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, cnt = m + n;
        int t = mean * cnt;
        for (int roll : rolls) t -= roll;
        if (t < n || t > 6 * n) return new int[0];

        int[] ans = new int[n];
        Arrays.fill(ans, t / n);
        if (t / n * n < t) {
            int d = t - (t / n * n), idx = 0;
            while (d-- > 0) ans[idx++]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.missingRolls(new int[]{3, 2, 4, 3}, 4, 2));
    }
}
