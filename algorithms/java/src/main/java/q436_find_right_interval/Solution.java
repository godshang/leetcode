package q436_find_right_interval;

import common.Util;

import java.util.Arrays;

public class Solution {

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] clone = new int[n][2];
        for (int i = 0; i < n; i++) {
            clone[i] = new int[]{intervals[i][0], i};
        }
        Arrays.sort(clone, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (clone[mid][0] >= intervals[i][1]) r = mid;
                else l = mid + 1;
            }
            ans[i] = clone[r][0] >= intervals[i][1] ? clone[r][1] : -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.findRightInterval(new int[][]{{1, 2}}));
        Util.printArray(solution.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
        Util.printArray(solution.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}}));
    }
}
