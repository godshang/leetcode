package q347_top_k_frequent_elements;

import common.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((e1, e2) -> e1[1] - e2[1]);
        for (int num : map.keySet()) {
            int count = map.get(num);
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        Util.printArray(solution.topKFrequent(new int[]{1}, 1));
    }
}
