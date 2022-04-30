package q908_smallest_range_i;

import java.util.Arrays;

public class Solution {

    public int smallestRangeI(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return Math.max(0, max - min - 2 * k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestRangeI(new int[]{1}, 0));
        System.out.println(solution.smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(solution.smallestRangeI(new int[]{1, 3, 6}, 3));
    }
}
