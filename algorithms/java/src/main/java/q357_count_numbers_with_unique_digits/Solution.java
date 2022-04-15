package q357_count_numbers_with_unique_digits;

public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int ans = 10;
        for (int i = 2, last = 9; i <= n; i++) {
            int cur = last * (10 - i + 1);
            ans += cur;
            last = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countNumbersWithUniqueDigits(2));
    }
}
