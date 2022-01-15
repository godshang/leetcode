package q390_elimination_game;

public class Solution {
    public int lastRemaining(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) {
                a1 = a1 + step;
            } else {
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 12; i++) {
            System.out.println("i = " + i + ", ans = " + solution.lastRemaining(i));
        }
    }
}
