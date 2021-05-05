package q986_interval_list_intersections;

import common.Util;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || B == null) return new int[][]{};

        List<int[]> res = new LinkedList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int a1 = A[i][0], a2 = A[i][1], b1 = B[j][0], b2 = B[j][1];
            if (a2 >= b1 && b2 >= a1) {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            if (b2 < a2) j++;
            else i++;
        }
        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        Util.printMatrix(solution.intervalIntersection(A, B));
    }
}
