package q464_can_i_win;

public class Solution {

    int n, t;
    int[] f = new int[1 << 20];

    int dfs(int state, int tot) {
        if (f[state] != 0) return f[state];
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1) continue;
            if (tot + i + 1 >= t) return f[state] = 1;
            if (dfs(state | (1 << i), tot + i + 1) == -1) return f[state] = 1;
        }
        return f[state] = -1;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        n = maxChoosableInteger; t = desiredTotal;
        if (n * (n + 1) / 2 < t) return false;
        if (t == 0) return true;
        return dfs(0, 0) == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.canIWin(10, 11));
//        System.out.println(solution.canIWin(10, 0));
        System.out.println(solution.canIWin(10, 1));
    }
}
