package q890_find_and_replace_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int[] map = new int[26], vis = new int[26];
        for (String w : words) {
            Arrays.fill(map, -1);
            Arrays.fill(vis, 0);
            boolean ok = true;
            for (int i = 0; i < pattern.length(); i++) {
                int c1 = w.charAt(i) - 'a', c2 = pattern.charAt(i) - 'a';
                if (map[c1] == -1 && vis[c2] == 0) {
                    map[c1] = c2;
                    vis[c2] = 1;
                } else if (map[c1] != c2) ok = false;
            }
            if (ok) ans.add(w);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }
}
