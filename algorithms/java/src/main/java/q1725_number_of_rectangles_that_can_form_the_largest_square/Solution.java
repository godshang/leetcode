package q1725_number_of_rectangles_that_can_form_the_largest_square;

public class Solution {

    public int countGoodRectangles(int[][] rectangles) {
        int ans = 0, max = Integer.MIN_VALUE;
        for (int[] rectangle : rectangles) {
            int k = Math.min(rectangle[0], rectangle[1]);
            if (k > max) {
                max = k;
                ans = 1;
            } else if (k == max) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countGoodRectangles(new int[][]{{5, 8}, {3, 9}, {5, 12}, {16, 5}}));
    }
}
