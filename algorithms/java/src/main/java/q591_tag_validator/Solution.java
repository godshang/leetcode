package q591_tag_validator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean isValid(String code) {
        int n = code.length();
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) return false;
                if (code.charAt(i + 1) == '/') {
                    int j = code.indexOf(">", i);
                    if (j < 0) return false;
                    String tag = code.substring(i + 2, j);
                    if (stack.isEmpty() || !stack.peek().equals(tag)) return false;
                    stack.pop();
                    i = j + 1;
                    if (stack.isEmpty() && i != n) return false;
                } else if (code.charAt(i + 1) == '!') {
                    if (stack.isEmpty()) return false;
                    if (i + 9 > n) return false;
                    String cdata = code.substring(i + 2, i + 9);
                    if (!cdata.equals("[CDATA[")) return false;
                    int j = code.indexOf("]]>", i);
                    if (j < 0) return false;
                    i = j + 1;
                } else {
                    int j = code.indexOf(">", i);
                    if (j < 0) return false;
                    String tag = code.substring(i + 1, j);
                    if (tag.length() < 1 || tag.length() > 9) return false;
                    for (int k = 0; k < tag.length(); k++) {
                        if (!Character.isUpperCase(tag.charAt(k))) return false;
                    }
                    stack.push(tag);
                    i = j + 1;
                }
            } else {
                if (stack.isEmpty()) return false;
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
    }

}
