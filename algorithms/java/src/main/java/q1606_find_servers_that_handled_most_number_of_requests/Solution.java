package q1606_find_servers_that_handled_most_number_of_requests;

import java.util.*;

public class Solution {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        int[] servers = new int[k];
        PriorityQueue<int[]> busy = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer s = available.ceiling(i % k);
            if (s == null) {
                s = available.first();
            }
            servers[s]++;
            busy.offer(new int[]{arrival[i] + load[i], s});
            available.remove(s);
        }

        List<Integer> ans = new ArrayList<>();
        int max = Arrays.stream(servers).max().getAsInt();
        for (int i = 0; i < k; i++) {
            if (servers[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}));
//        System.out.println(solution.busiestServers(3, new int[]{1, 2, 3, 4, 8, 9, 10}, new int[]{5, 2, 10, 3, 1, 2, 2}));
        System.out.println(solution.busiestServers(2, new int[]{1, 2, 3}, new int[]{1000000000, 1, 1000000000}));
    }
}
