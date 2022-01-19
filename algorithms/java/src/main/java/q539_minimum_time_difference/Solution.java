package q539_minimum_time_difference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0 = getMinutes(timePoints.get(0));
        int pre = t0;
        for (int i = 1; i < timePoints.size(); i++) {
            int t = getMinutes(timePoints.get(i));
            ans = Math.min(ans, t - pre);
            pre = t;
        }
        ans = Math.min(ans, t0 + 1440 - pre);
        return ans;
    }

    public int getMinutes(String timePoint) {
        return ((timePoint.charAt(0) - '0') * 10 + (timePoint.charAt(1) - '0')) * 60
                + (timePoint.charAt(3) - '0') * 10 + (timePoint.charAt(4) - '0');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinDifference(Arrays.asList("23:59", "00:00")));
        System.out.println(solution.findMinDifference(Arrays.asList("00:00", "23:59", "00:00")));
    }
}
