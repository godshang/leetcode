package q1823_find_the_winner_of_the_circular_game;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheWinner(5, 2));
    }
}
