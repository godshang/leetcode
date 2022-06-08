package q1037_valid_boomerang;

public class Solution {

    public boolean isBoomerang(int[][] points) {
        int[] p1 = points[0], p2 = points[1], p3 = points[2];

        int[] v1 = {p2[0] - p1[0], p2[1] - p1[1]};
        int[] v2 = {p3[0] - p1[0], p3[1] - p1[1]};

        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        System.out.println(solution.isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(solution.isBoomerang(new int[][]{{0, 0}, {0, 2}, {2, 1}}));
    }
}
