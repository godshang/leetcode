package q710_random_pick_with_blacklist;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Integer, Integer> mapping = new HashMap<>();
    private int sz;

    public Solution(int N, int[] blacklist) {
        sz = N - blacklist.length;
        for (int b : blacklist) {
            mapping.put(b, Integer.MIN_VALUE);
        }

        int last = N - 1;
        for (int b : blacklist) {
            if (b >= sz) {
                continue;
            }
            while (mapping.containsKey(last)) {
                last--;
            }
            mapping.put(b, last);
            last--;
        }
    }

    public int pick() {
        int i = (int) (Math.random() * sz);
        if (mapping.containsKey(i)) {
            return mapping.get(i);
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(3, new int[]{1});
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
    }
}
