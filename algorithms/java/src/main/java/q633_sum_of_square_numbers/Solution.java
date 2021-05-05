package q633_sum_of_square_numbers;

public class Solution {

    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c) + 1;
        for (int a = 0; a < max; a++) {
            int b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b == c) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.judgeSquareSum(5));
//        System.out.println(solution.judgeSquareSum(3));
//        System.out.println(solution.judgeSquareSum(4));
//        System.out.println(solution.judgeSquareSum(2));
//        System.out.println(solution.judgeSquareSum(1));
        System.out.println(solution.judgeSquareSum(0));
    }
}
