package q1576_replace_all_s_to_avoid_consecutive_repeatin_characters;

public class Solution {

    public String modifyString(String s) {
        char[] chs = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (chs[i] == '?') {
                for (int j = 0; j < 26; j++) {
                    char c = (char) (j + 'a');
                    if (i - 1 >= 0 && chs[i - 1] == c) continue;
                    if (i + 1 < n && chs[i + 1] == c) continue;
                    chs[i] = c;
                    break;
                }
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.modifyString("?zs"));
//        System.out.println(solution.modifyString("ubv?w"));
        System.out.println(solution.modifyString("j?qg??b"));
//        System.out.println(solution.modifyString("??yw?ipkj?"));
    }
}
