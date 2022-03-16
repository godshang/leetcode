package q42_trapping_rain_water;

import java.util.Stack;

public class Solution {

    public int trap(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int minHeight = Math.min(maxLeft[i], maxRight[i]);
            if (minHeight > height[i]) {
                sum += minHeight - height[i];
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) break;
                int w = i - stack.peek() - 1;
                int min = Math.min(height[i], height[stack.peek()]);
                ans += w * (min - h);
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution.trap2(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
