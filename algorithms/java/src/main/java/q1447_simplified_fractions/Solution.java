package q1447_simplified_fractions;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(j, i) == 1) {
                    ans.add(j + "/" + i);
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifiedFractions(4));
    }
}
