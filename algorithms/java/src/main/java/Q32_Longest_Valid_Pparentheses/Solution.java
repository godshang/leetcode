package Q32_Longest_Valid_Pparentheses;

public class Solution {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
