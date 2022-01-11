package q1185_day_of_the_week;

public class Solution {

    static String[] weekday = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {

        int ans = 4;
        for (int i = 1971; i < year; i++) {
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || (i % 400 == 0);
            ans += isLeap ? 366 : 365;
        }

        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        for (int i = 1; i < month; i++) {
            ans += monthDay[i - 1];
            if (i == 2 && isLeap) ans++; // 闰年2月多29天
        }

        ans += day;

        return weekday[ans % 7];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.dayOfTheWeek(1, 1, 1971));
//        System.out.println(solution.dayOfTheWeek(31, 8, 2019));
        System.out.println(solution.dayOfTheWeek(21, 12, 1980));
    }
}
