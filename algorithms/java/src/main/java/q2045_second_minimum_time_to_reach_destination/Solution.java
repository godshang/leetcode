package q2045_second_minimum_time_to_reach_destination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        int[][] dis = new int[n][2];
        dis[0][1] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            dis[i][0] = dis[i][1] = Integer.MAX_VALUE;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int head = cur[0], path = cur[1];
            for (int u : adj[head]) {
                if (dis[u][0] > path + 1) {
                    dis[u][0] = path + 1;
                    q.offer(new int[]{u, dis[u][0]});
                } else if ((dis[u][0] < path + 1) && (dis[u][1] > path + 1)) {
                    dis[u][1] = path + 1;
                    q.offer(new int[]{u, dis[u][1]});
                }
            }
        }
        int path = dis[n - 1][1];
        return pathToTime(path, time, change);
    }

    private int pathToTime(int len, int time, int change) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += time;
            if (i == len - 1) break;
            int period = sum / change;
            if ((period & 1) == 1) {
                sum = (period + 1) * change;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.secondMinimum(5, new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}}, 3, 5));
    }
}
