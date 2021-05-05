package q149_max_points_on_a_line;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    int max = 0;

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
        dfs(points, 0, new LinkedList<>());
        return max;
    }

    private void dfs(int[][] points, int startIndex, LinkedList<int[]> selected) {
        max = Math.max(max, selected.size());
        for (int i = startIndex; i < points.length; i++) {
            if (selected.size() < 2) {
                selected.add(points[i]);
                dfs(points, i + 1, selected);
                selected.removeLast();
            } else {
                int[] pointA = selected.get(0), pointB = selected.get(1);
                if (test(pointA[0], pointA[1], pointB[0], pointB[1], points[i][0], points[i][1])) {
                    selected.add(points[i]);
                    dfs(points, i + 1, selected);
                    selected.removeLast();
                }
            }
        }
    }

    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        return (long) (y2 - y1) * (x - x2) == (long) (x2 - x1) * (y - y2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(solution.maxPoints(points));
    }
}
