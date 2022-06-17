package q1051_height_checker;

import java.util.Arrays;

public class Solution {

    public int heightChecker(int[] heights) {
        int max = Arrays.stream(heights).max().getAsInt();
        int[] cnt = new int[max + 1];
        for (int h : heights) {
            cnt[h]++;
        }
        int idx = 0, ans = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= cnt[i]; j++) {
                if (heights[idx] != i) {
                    ans++;
                }
                idx++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }
}
