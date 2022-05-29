package q1021_remove_outermost_parentheses;

public class Solution {

    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0, cnt = 0; j < n; j++) {
            if (s.charAt(j) == '(') cnt++;
            else if (s.charAt(j) == ')') cnt--;
            if (cnt == 0) {
                sb.append(s, i + 1, j);
                i = j + 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses("(()())(())"));
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(solution.removeOuterParentheses("()()"));
    }
}
