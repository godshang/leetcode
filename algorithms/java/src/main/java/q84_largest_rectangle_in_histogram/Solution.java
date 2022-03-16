package q84_largest_rectangle_in_histogram;

import java.util.Stack;

public class Solution {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int[] result = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            int left = i, right = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }
            int width = right - left + 1;
            result[i] = width * heights[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < result.length; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        int ans = 0;
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                int cur = stack.pop();
                int left = stack.peek() + 1;
                int right = i - 1;
                ans = Math.max(ans, (right - left + 1) * newHeights[cur]);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(solution.largestRectangleArea2(new int[]{}));
        System.out.println(solution.largestRectangleArea2(new int[]{1, 1}));
    }
}
