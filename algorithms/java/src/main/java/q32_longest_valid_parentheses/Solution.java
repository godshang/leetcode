package q32_longest_valid_parentheses;

import java.util.Stack;

public class Solution {

    public int longestValidParentheses_dp(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 0;
        int[] dp = new int[s.length()]; // dp[i]表示以i为结尾的最长有效括号长度
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {
                    if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.longestValidParentheses_dp("(()"));
//        System.out.println(solution.longestValidParentheses_dp(")()())"));
//        System.out.println(solution.longestValidParentheses_dp("()"));
        System.out.println(solution.longestValidParentheses_dp("()(()"));
    }
}
