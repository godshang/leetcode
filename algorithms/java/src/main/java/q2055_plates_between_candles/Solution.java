package q2055_plates_between_candles;

import common.Util;

public class Solution {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length(), m = queries.length;
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }

        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }

        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int c = right[a], d = left[b];
            if (c == -1 || d == -1 || c >= d) {
                ans[i] = 0;
            } else {
                ans[i] = preSum[d] - preSum[c];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}}));
        Util.printArray(solution.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}}));
    }
}
