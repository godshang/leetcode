package q961_n_repeated_element_in_size_2n_array;

public class Solution {

    public int repeatedNTimes(int[] nums) {
        int m = nums.length, n = m / 2;
        int[] a = new int[10010];
        for (int num : nums) {
            if (++a[num] > 1) return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(solution.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(solution.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
}
