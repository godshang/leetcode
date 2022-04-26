package q883_projection_area_of_3d_shapes;

public class Solution {

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xy = 0, yz = 0, xz = 0;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) xy += 1;
                a = Math.max(a, grid[i][j]);
                b = Math.max(b, grid[j][i]);
            }
            xz += a;
            yz += b;
        }
        return xz + yz + xy;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.projectionArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(solution.projectionArea(new int[][]{{2}}));
        System.out.println(solution.projectionArea(new int[][]{{1, 0}, {0, 2}}));
    }
}
