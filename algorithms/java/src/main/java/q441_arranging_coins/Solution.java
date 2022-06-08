package q441_arranging_coins;

public class Solution {

    public int arrangeCoins(int n) {
        long l = 0, r = n;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * (mid + 1) / 2 <= n) l = mid;
            else r = mid - 1;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrangeCoins(5));
    }
}
