package q747_largest_number_at_least_twice_of_others;

public class Solution {

    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int a = -1, b = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[b]) {
                a = b;
                b = i;
            } else if (a == -1 || nums[i] > nums[a]) {
                a = i;
            }
        }
        return nums[b] >= nums[a] * 2 ? b : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(solution.dominantIndex(new int[]{1, 0}));
    }
}
