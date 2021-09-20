package q22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesisDFS(n, n, "", res);
        return res;
    }

    private void generateParenthesisDFS(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right)
            return;
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        if (left > 0)
            generateParenthesisDFS(left - 1, right, out + "(", res);
        if (right > 0)
            generateParenthesisDFS(left, right - 1, out + ")", res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
    }
}
