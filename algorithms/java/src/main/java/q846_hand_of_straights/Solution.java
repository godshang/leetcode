package q846_hand_of_straights;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            count.put(hand[i], count.getOrDefault(hand[i], 0) + 1);
            pq.offer(hand[i]);
        }
        while (!pq.isEmpty()) {
            int polled = pq.poll();
            if (count.get(polled) == 0) continue;
            for (int i = 0; i < groupSize; i++) {
                int c = count.getOrDefault(polled + i, 0);
                if (c == 0) return false;
                count.put(polled + i, c - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }
}
