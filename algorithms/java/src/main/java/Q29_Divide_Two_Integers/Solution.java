package q29_divide_two_integers;

public class Solution {

    public int divide(int dividend, int divisor) {

        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long result = divide(Math.abs((long) dividend), Math.abs((long) divisor));
        if (result > Integer.MAX_VALUE) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int) (negative ? -result : result);
    }

    private long divide(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;

        long sum = divisor;
        long divide = 1;

        while ((sum + sum) < dividend) {
            sum += sum;
            divide += divide;
        }
        return divide + divide(dividend - sum, divisor);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10, 3));
        System.out.println(solution.divide(7, -3));
        System.out.println(solution.divide(16, 3));
    }
}
