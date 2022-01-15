package q1716_calculate_money_in_leetcode_bank;

public class Solution {

    public int totalMoney(int n) {
        int res = 0;
        int week = n / 7;
        for (int i = 0; i < week; i++) {
            int weekStart = i + 1, weekEnd = weekStart + 6;
            res += 7 * (weekStart + weekEnd) / 2;
        }
        int day = n % 7;
        int dayStart = week + 1, dayEnd = dayStart + day - 1;
        res += day * (dayStart + dayEnd) / 2;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalMoney(4));
        System.out.println(solution.totalMoney(10));
        System.out.println(solution.totalMoney(20));
    }
}
