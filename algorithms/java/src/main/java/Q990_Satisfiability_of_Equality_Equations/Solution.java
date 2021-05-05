package q990_satisfiability_of_equality_equations;

import common.UF;

public class Solution {

    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                uf.union(x, y);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                if (uf.connected(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println(solution.equationsPossible(new String[]{"a==b", "b==a"}));
    }
}
