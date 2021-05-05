package q172_factorial_trailing_zeroes;

public class Solution {

    public int trailingZeroes(int n) {
        int num = 0;
        while (n >= 5) {
            num += n / 5; // // 阶乘中有多少5，结果就有多少个0
            n = n / 5;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(3));
        System.out.println(solution.trailingZeroes(5));
    }
}
