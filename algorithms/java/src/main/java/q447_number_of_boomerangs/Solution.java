package q447_number_of_boomerangs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] q : points) {
                int dis = distance(p, q);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Integer dis : map.keySet()) {
                int m = map.get(dis);
                ans += m * (m - 1);
            }
        }
        return ans;
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfBoomerangs(new int[][]{{0, 0}}));
        System.out.println(solution.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
