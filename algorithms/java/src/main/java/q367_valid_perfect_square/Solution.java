package q367_valid_perfect_square;

public class Solution {

    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * mid <= num) l = mid;
            else r = mid - 1;
        }
        return r * r == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.isPerfectSquare(16));
    }
}
