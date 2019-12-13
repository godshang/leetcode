package Q15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
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
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printResult(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
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
