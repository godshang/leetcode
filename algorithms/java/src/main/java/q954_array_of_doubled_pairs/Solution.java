package q954_array_of_doubled_pairs;

import java.util.*;

public class Solution {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : arr) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) return false;

        List<Integer> list = new ArrayList<>(cnt.keySet());
        Collections.sort(list, Comparator.comparingInt(Math::abs));

        for (Integer i : list) {
            if (cnt.getOrDefault(2 * i, 0) < cnt.get(i)) return false;
            cnt.put(2 * i, cnt.getOrDefault(2 * i, 0) - cnt.get(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canReorderDoubled(new int[]{3, 1, 3, 6}));
        System.out.println(solution.canReorderDoubled(new int[]{2, 1, 2, 6}));
        System.out.println(solution.canReorderDoubled(new int[]{4, -2, 2, -4}));
    }
}
