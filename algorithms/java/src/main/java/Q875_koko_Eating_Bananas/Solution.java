package q875_koko_eating_bananas;

public class Solution {

    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = max(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFiniash(piles, H, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canFiniash(int[] piles, int H, int k) {
        int time = 0;
        for (int pile : piles) {
            time += timeOf(pile, k);
        }
        return time <= H;
    }

    public int timeOf(int pile, int k) {
        return (pile / k) + ((pile % k > 0) ? 1 : 0);
    }

    public int max(int[] piles) {
        int max = 0;
        for (int pile : piles)
            max = Math.max(max, pile);
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}
