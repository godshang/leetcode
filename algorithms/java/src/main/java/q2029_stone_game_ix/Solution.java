package q2029_stone_game_ix;

public class Solution {

    public boolean stoneGameIX(int[] stones) {
        int[] cnts = new int[3];
        for (int i : stones) cnts[i % 3]++;
        return cnts[0] % 2 == 0 ? !(cnts[1] == 0 || cnts[2] == 0) : !(Math.abs(cnts[1] - cnts[2]) <= 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.stoneGameIX(new int[]{2, 1}));
    }
}
