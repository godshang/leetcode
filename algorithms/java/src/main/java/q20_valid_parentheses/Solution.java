package q20_valid_parentheses;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                Character t = stack.empty() ? '#' : stack.pop();
                if (c == ')' && !t.equals('(')) {
                    return false;
                } else if (c == ']' && !t.equals('[')) {
                    return false;
                } else if (c == '}' && !t.equals('{')) {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("]"));
        System.out.println(solution.isValid("["));
    }
}
