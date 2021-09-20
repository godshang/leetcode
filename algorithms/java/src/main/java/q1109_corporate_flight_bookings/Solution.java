package q1109_corporate_flight_bookings;

import common.Difference;
import common.Util;

public class Solution {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            difference.incr(i, j, val);
        }
        return difference.result();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5));
    }
}
