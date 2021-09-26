package q599_minimum_index_sum_of_two_lists;

import common.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            map1.put(list1[i], i);
        for (int i = 0; i < list2.length; i++)
            map2.put(list2[i], i);

        List<String> res = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (String str : list1) {
            if (map2.containsKey(str)) {
                int indexSum = map1.get(str) + map2.get(str);
                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    res.clear();
                    res.add(str);
                } else if (indexSum == minIndexSum) {
                    res.add(str);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})
        );
        Util.printArray(solution.findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"}
        ));
    }
}
