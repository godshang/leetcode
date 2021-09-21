package q500_keyboard_row;

import common.Util;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    String line1 = "qwertyuiop", line2 = "asdfghjkl", line3 = "zxcvbnm";

    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String lowerword = word.toLowerCase();
            int line = 0;
            boolean sameLine = true;
            for (int i = 0; i < lowerword.length(); i++) {
                char c = lowerword.charAt(i);
                if (line == 0) line = find(c);
                else if (line != find(c)) {
                    sameLine = false;
                    break;
                }
            }
            if (sameLine) res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }

    private int find(char c) {
        if (line1.indexOf(c) >= 0) return 1;
        else if (line2.indexOf(c) >= 0) return 2;
        else if (line3.indexOf(c) >= 0) return 3;
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
        Util.printArray(solution.findWords(new String[]{"omk"}));
        Util.printArray(solution.findWords(new String[]{"adsdf", "sfd"}));
    }
}
