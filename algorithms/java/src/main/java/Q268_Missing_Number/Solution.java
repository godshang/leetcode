package q268_missing_number;

import javax.swing.*;

public class Solution {

//    public int missingNumber(int[] nums) {
//        int[] pos = new int[nums.length + 1];
//        for (int i = 0, len = pos.length; i < len; i++)
//            pos[i] = -1;
//        for (int i = 0, len = nums.length; i < len; i++)
//            pos[nums[i]] = nums[i];
//        for (int i = 0, len = pos.length; i < len; i++)
//            if (pos[i] == -1)
//                return i;
//        return 0;
//    }

    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += i - nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{0}));
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
