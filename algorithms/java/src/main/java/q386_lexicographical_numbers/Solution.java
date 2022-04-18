package q386_lexicographical_numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            ans.add(num);
            if (num * 10 <= n) {
                num = num * 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num = num / 10;
                }
                num++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lexicalOrder(13));
        System.out.println(solution.lexicalOrder(2));
    }
}
