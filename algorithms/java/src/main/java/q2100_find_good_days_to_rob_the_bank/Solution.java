package q2100_find_good_days_to_rob_the_bank;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] g = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] == security[i - 1]) continue;
            g[i] = security[i] > security[i - 1] ? 1 : -1;
        }
        int[] a = new int[n + 1], b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + (g[i - 1] == 1 ? 1 : 0);
            b[i] = b[i - 1] + (g[i - 1] == -1 ? 1 : 0);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            int c1 = a[i + 1] - a[i + 1 - time], c2 = b[i + 1 + time] - b[i + 1];
            if (c1 == 0 && c2 == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2));
    }
}
