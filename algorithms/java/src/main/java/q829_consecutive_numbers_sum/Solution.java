package q829_consecutive_numbers_sum;

public class Solution {

    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        n *= 2;
        for (int k = 1; k * k < n; k++) {
            if (n % k != 0) continue;
            if ((n / k - (k - 1)) % 2 == 0) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.consecutiveNumbersSum(5));
        System.out.println(solution.consecutiveNumbersSum(9));
        System.out.println(solution.consecutiveNumbersSum(15));
    }
}
