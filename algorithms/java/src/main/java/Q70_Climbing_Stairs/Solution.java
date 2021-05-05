package q70_climbing_stairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Approach I Top-Down
     */
//    public int climbStairs(int n) {
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }


    /**
     * Approach II Top-Down (using array)
     */
//    public int climbStairs(int n) {
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//
//        int[] res = new int[n];
//        for (int i = 0; i < res.length; i++)
//            res[i] = -1;
//        res[0] = 1; res[1] = 2;
//
//        return dp(n - 1, res);
//    }
//
//    private int dp(int n, int[] res) {
//        if (res[n] == -1)
//            res[n] = dp(n - 1, res) + dp(n - 2, res);
//        return res[n];
//    }


    /**
     * Approach III Top-Down (using hash table)
     */
//    public int climbStairs(int n) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        map.put(0, 0);
//        map.put(1, 1);
//        map.put(2, 2);
//
//        return dp(n, map);
//    }
//
//    private int dp(int n, Map<Integer, Integer> map) {
//        if (map.containsKey(n))
//            return map.get(n);
//
//        return dp(n - 1, map) + dp(n - 2, map);
//    }

    /**
     * Approach IV Bottom-Top (using array)
     */
//    public int climbStairs(int n) {
//        if (n == 1) return 1;
//
//        int[] res = new int[n];
//        for (int i = 0; i < res.length; i++)
//            res[i] = 0;
//        res[0] = 1; res[1] = 2;
//
//        for (int i = 2; i < n; i++) {
//            res[i] = res[i - 1] + res[i - 2];
//        }
//        return res[n - 1];
//    }

    /**
     * Approach V Bottom-Top
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int a = 1, b = 2;
        for (int i = 2; i < n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
    }
}
