package q18_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = threeSumTarget(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
            for (List<Integer> tuple : list) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    private List<List<Integer>> threeSumTarget(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = twoSumTarget(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
            for (List<Integer> tuple : list) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    private List<List<Integer>> twoSumTarget(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (i < j) {
            int left = nums[i], right = nums[j], sum = left + right;
            if (sum < target) {
                while (i < j && nums[i] == left) i++;
            } else if (sum > target) {
                while (i < j && nums[j] == right) j--;
            } else {
                res.add(new ArrayList<>(Arrays.asList(left, right)));
                while (i < j && nums[i] == left) i++;
                while (i < j && nums[j] == right) j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printResult(solution.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
//        printResult(solution.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
//        printResult(solution.fourSum(new int[]{0, 0, 0, 0}, 0));
    }

    private static void printResult(List<List<Integer>> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("\r\n");
        for (List<Integer> list : result) {
            sb.append("\t").append("[");
            for (Integer num : list) {
                sb.append(num).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]").append("\r\n");
        }
        sb.append("]");

        System.out.println(sb.toString());
    }
}
