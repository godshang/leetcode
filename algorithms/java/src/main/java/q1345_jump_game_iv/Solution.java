package q1345_jump_game_iv;

import java.util.*;

public class Solution {

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = map.computeIfAbsent(arr[i], k -> new ArrayList<>());
            list.add(i);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        dist[0] = 0;
        while (!d.isEmpty()) {
            int t = d.pollFirst(), step = dist[t];
            if (t == n - 1) return step;
            if (t + 1 < n && dist[t + 1] == Integer.MAX_VALUE) {
                d.addLast(t + 1);
                dist[t + 1] = step + 1;
            }
            if (t - 1 > 0 && dist[t - 1] == Integer.MAX_VALUE) {
                d.add(t - 1);
                dist[t - 1] = step + 1;
            }
            List<Integer> list = map.getOrDefault(arr[t], new ArrayList<>());
            for (int ne : list) {
                if (dist[ne] == Integer.MAX_VALUE) {
                    d.addLast(ne);
                    dist[ne] = step + 1;
                }
            }
            map.remove(arr[t]);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        System.out.println(solution.minJumps(new int[]{7}));
        System.out.println(solution.minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
    }
}
