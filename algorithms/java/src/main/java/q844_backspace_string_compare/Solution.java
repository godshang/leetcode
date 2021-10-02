package q844_backspace_string_compare;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean backspaceCompare(String s, String t) {
        String s1 = after(s);
        String s2 = after(t);
        return s1.equals(s2);
    }

    private String after(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
        System.out.println(solution.backspaceCompare("a##c", "#a#c"));
        System.out.println(solution.backspaceCompare("a#c", "b"));
    }
}
