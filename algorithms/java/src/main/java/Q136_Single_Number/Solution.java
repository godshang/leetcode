package q136_single_number;

public class Solution {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[] { 2,2,1 }));
        System.out.println(solution.singleNumber(new int[] { 4,1,2,1,2 }));
    }
}
