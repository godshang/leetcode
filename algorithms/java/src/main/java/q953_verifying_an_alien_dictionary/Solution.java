package q953_verifying_an_alien_dictionary;

import java.util.Arrays;

public class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        int[] or = new int[26];
        for (int i = 0; i < order.length(); i++) {
            or[order.charAt(i) - 'a'] = i;
        }
        String[] clone = words.clone();
        Arrays.sort(clone, (a, b) -> {
            int i = 0, j = 0, n = a.length(), m = b.length();
            while (i < n && j < m) {
                int c1 = a.charAt(i) - 'a', c2 = b.charAt(j) - 'a';
                if (c1 != c2) return or[c1] - or[c2];
                i++;
                j++;
            }
            if (i < n) return 1;
            if (j < m) return -1;
            return 0;
        });
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(clone[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
