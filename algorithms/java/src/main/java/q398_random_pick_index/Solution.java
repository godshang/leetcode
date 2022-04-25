package q398_random_pick_index;

import java.util.*;

public class Solution {

    private int[] nums;
    private Map<Integer, List<Integer>> targetToIndexListMap = new HashMap<>();

    public Solution(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = targetToIndexListMap.computeIfAbsent(num, k -> new ArrayList<>());
            list.add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = targetToIndexListMap.get(target);
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(3));
    }
}
