package q691_stickers_to_spell_word;

import java.util.Arrays;

public class Solution {

    int N = 20, M = 1 << 20, INF = 50;
    int[] f = new int[M];
    String[] ss;
    String t;

    public int minStickers(String[] stickers, String target) {
        ss = stickers;
        t = target;
        Arrays.fill(f, -1);
        int ans = dfs(0);
        return ans == INF ? -1 : ans;
    }

    int dfs(int state) {
        int n = t.length();
        if (state == ((1 << n) - 1)) return 0;
        if (f[state] != -1) return f[state];
        int ans = INF;
        for (String s : ss) {
            int nstate = state;
            out:
            for (char c : s.toCharArray()) {
                for (int i = 0; i < n; i++) {
                    if (t.charAt(i) == c && (((nstate >> i) & 1) == 0)) {
                        nstate |= (1 << i);
                        continue out;
                    }
                }
            }
            if (nstate != state) {
                ans = Math.min(ans, dfs(nstate) + 1);
            }
        }
        return f[state] = ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minStickers(new String[]{"control","heart","interest","stream","sentence","soil","wonder","them","month","slip","table","miss","boat","speak","figure","no","perhaps","twenty","throw","rich","capital","save","method","store","meant","life","oil","string","song","food","am","who","fat","if","put","path","come","grow","box","great","word","object","stead","common","fresh","the","operate","where","road","mean"}, "stoodcrease"));
//        System.out.println(solution.minStickers(new String[]{"notice", "possible"}, "basicbasic"));
    }
}
