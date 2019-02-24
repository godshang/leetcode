package Q18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1, sum = tmp - nums[j];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        printResult(solution.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
//        printResult(solution.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
        printResult(solution.fourSum(new int[]{0, 0, 0, 0}, 0));
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
