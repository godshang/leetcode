package q875_koko_eating_bananas;

import java.util.Arrays;

public class Solution {

    public int minEatingSpeed(int[] piles, int H) {
        int max = Arrays.stream(piles).max().getAsInt();
        int left = 1, right = max;
        while (left < right) {
            int mid = left + right>> 1;
            if (canFiniash(piles, H, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean canFiniash(int[] piles, int H, int k) {
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil(pile * 1.0 / k);
        }
        return time <= H;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}
