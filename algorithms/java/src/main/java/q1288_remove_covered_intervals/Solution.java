package q1288_remove_covered_intervals;

import java.util.Arrays;

public class Solution {

    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null) return 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int result = 0;
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (left <= interval[0] && right >= interval[1]) {
                result++;
            }
            if (right >= interval[0] && right <= interval[1]) {
                right = interval[1];
            }
            if (right < interval[0]) {
                left = interval[0];
                right = interval[1];
            }
        }

        return intervals.length - result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}}));
    }
}
