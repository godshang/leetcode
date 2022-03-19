package q85_maximal_rectangle;

import java.util.Stack;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] heights = new int[cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangle(heights));
        }
        return ans;
    }

    private int largestRectangle(int[] heights) {
        int ans = 0;
        int[] hs = new int[heights.length + 2];
        System.arraycopy(heights, 0, hs, 1, heights.length);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < hs.length; i++) {
            while (!stack.isEmpty() && hs[stack.peek()] > hs[i]) {
                int cur = stack.pop();
                int left = stack.peek() + 1;
                int right = i - 1;
                ans = Math.max(ans, (right - left + 1) * hs[cur]);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}
