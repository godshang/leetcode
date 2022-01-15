package q373_find_k_pairs_with_smallest_sums;

import common.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
        });
        for (int i = 0; i < Math.min(n, k); i++) {
            pq.add(new int[]{i, 0});
        }
        while (res.size() < k && !pq.isEmpty()) {
            int[] poll = pq.poll();
            int a = poll[0], b = poll[1];
            res.add(new ArrayList<Integer>() {{
                add(nums1[a]);
                add(nums2[b]);
            }});
            if (b + 1 < m) {
                pq.offer(new int[]{a, b + 1});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Util.printList(solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        Util.printList(solution.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
    }
}
