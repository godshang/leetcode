package q316_remove_duplicate_letters;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] inStack = new boolean[256];
        
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        for (char c : s.toCharArray()) {
            count[c]--;
            
            if (inStack[c]) continue;
            
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            
            stack.push(c);
            inStack[c] = true;
        }
        
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }
}
