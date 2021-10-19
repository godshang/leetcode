package q45_jump_game_ii;

public class Solution {


    public int jump(int[] nums) {
        int steps = 0;
        int start = 0, end = 1;
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;
            end = maxPos + 1;
            steps++;
        }
        return steps;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
    }
}
