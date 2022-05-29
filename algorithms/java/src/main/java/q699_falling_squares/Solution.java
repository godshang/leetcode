package q699_falling_squares;

import java.util.*;

public class Solution {

    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length, maxHeight = 0;
        List<Integer> heights = new ArrayList<>();
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = positions[i][0], height = positions[i][1], right = positions[i][0] + positions[i][1];

            int baseHeight = 0;
            for (int[] interval : intervals) {
                int s = interval[0], e = interval[1], h = interval[2];
                if (s >= right || e <= left) continue;
                baseHeight = Math.max(baseHeight, h);
            }
            int newHeight = baseHeight + height;
            intervals.add(new int[]{left, right, newHeight});

            maxHeight = Math.max(maxHeight, newHeight);
            heights.add(maxHeight);
        }
        return heights;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
    }
}
