package q819_most_common_word;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String word : banned) {
            set.add(word);
        }

        int max = Integer.MIN_VALUE;
        String res = null;
        Map<String, Integer> map = new HashMap<>();
        String[] array = paragraph.toLowerCase().split("\\s|,|\\.|;|!|\\?|'");
        for (String word : array) {
            if (word.isEmpty() || set.contains(word)) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
            if (map.get(word) > max) {
                res = word;
                max = map.get(word);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}));
        System.out.println(solution.mostCommonWord("a, a, a, a, b,b,b,c, c",
                new String[]{"a"}));
    }
}
