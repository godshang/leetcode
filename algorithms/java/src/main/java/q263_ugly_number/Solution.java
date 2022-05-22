package q263_ugly_number;

public class Solution {

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isUgly(1));
        System.out.println(solution.isUgly(6));
        System.out.println(solution.isUgly(14));
    }
}
