package q169_majority_element;

public class Solution {

    public int majorityElement(int[] nums) {
        int count = 1, majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                majority = nums[i];
            } else if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[] {3,2,3}));
        System.out.println(solution.majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}
